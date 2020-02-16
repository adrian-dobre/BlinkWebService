package ui.web.blink.infrastructure.helpers

import com.github.kittinunf.fuel.core.*
import com.github.kittinunf.result.Result
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.net.URLEncoder

open class MediaService(private val baseUrl: String) {

    private val logger: Logger = LoggerFactory.getLogger(BaseService::class.java)
    private val fuel: FuelManager = FuelManager()

    init {
        fuel.addRequestInterceptor { next: (Request) -> Request ->
            { request ->
                logger.debug("${request.method} req.:\n$request")
                next(request)
            }
        }

        fuel.addResponseInterceptor { next: (Request, Response) -> Response ->
            { request, response ->
                if (response.isSuccessful || response.isStatusRedirection) {
                    logger.debug(
                        "${request.method} resp.:\n$response"
                    )
                } else {
                    logger.error(
                        "${request.method} resp.:\n$response"
                    )
                }
                next(request, response)
            }
        }
    }

    private fun handleResponse(
        response: Result<String, FuelError>,
        rawResponse: Response
    ): Pair<String, Response> {
        when (response) {
            is Result.Failure -> {
                throw response.getException()
            }
            is Result.Success -> {
                return Pair(response.get(), rawResponse)
            }
        }
    }

    protected fun baseRequest(
        request: Request,
        options: RequestOptions
    ): Pair<String, Response> {
        val headersCopy: MutableMap<String, String> = options.headers.toMutableMap()

        val (_, response, result) = request
            .header(headersCopy)
            .responseString()

        if (response.statusCode !in 200..299) {
            if (response.statusCode in listOf(401, 403)) {
                throw UnauthorizedException("Unauthorized. Details: \n $response")
            }
            throw RuntimeException("External API Error: Unexpected HTTP Status Code ${response.statusCode}. Details: \n $response")
        }

        return handleResponse(result, response)
    }

    private fun buildRequestUrl(baseUrl: String, options: RequestOptions): String {
        var baseUrlCopy = baseUrl

        if (options.path != null) {
            baseUrlCopy += "/${options.path}"
        }

        options.params.query.forEach { queryParam ->
            val separator = if (baseUrlCopy.contains('?')) {
                '&'
            } else {
                '?'
            }
            baseUrlCopy += "$separator${queryParam.first}=${URLEncoder.encode(queryParam.second, "UTF-8")}"
        }
        return baseUrlCopy
    }


    fun get(
        options: RequestOptions
    ): Pair<String, Response> {
        return baseRequest(
            fuel.get(buildRequestUrl(baseUrl, options)),
            options
        )
    }
}