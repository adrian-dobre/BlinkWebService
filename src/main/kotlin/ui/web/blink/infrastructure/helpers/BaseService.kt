package ui.web.blink.infrastructure.helpers

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.github.kittinunf.fuel.core.*
import com.github.kittinunf.result.Result
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.net.URLEncoder

class UnauthorizedException(message: String?) : Exception(message)

data class RequestParams(
    var query: List<Pair<String, String>> = listOf(),
    var body: Any = {}
)

data class RequestOptions(
    var params: RequestParams = RequestParams(),
    var headers: MutableMap<String, String> = mutableMapOf(),
    var sessionId: String? = null,
    var path: String? = null
)

open class BaseService(private val baseUrl: String) {

    private val objectMapper = ObjectMapper().registerModule(KotlinModule())
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

    private fun <T> handleResponse(
        response: Result<String, FuelError>,
        dto: TypeReference<T>,
        rawResponse: Response
    ): Pair<T, Response> {
        when (response) {
            is Result.Failure -> {
                throw response.getException()
            }
            is Result.Success -> {
                return Pair(objectMapper.readValue(response.get(), dto), rawResponse)
            }
        }
    }

    protected fun <T> baseRequest(
        request: Request,
        options: RequestOptions,
        dto: TypeReference<T>
    ): Pair<T, Response> {
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

        return handleResponse(result, dto, response)
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

    inline fun <reified T> getTypeReference(): TypeReference<T> {
        return object : TypeReference<T>() {}
    }

    inline fun <reified T> post(
        options: RequestOptions,
        dto: Class<T>
    ): Pair<T, Response> {
        return post(options, getTypeReference<T>())
    }

    fun <T> post(
        options: RequestOptions,
        dto: TypeReference<T>
    ): Pair<T, Response> {
        val body = objectMapper.writeValueAsString(options.params.body)
        return baseRequest(
            fuel.post(buildRequestUrl(baseUrl, options)).body(body),
            options,
            dto
        )
    }

    inline fun <reified T> get(
        options: RequestOptions,
        dto: Class<T>
    ): Pair<T, Response> {
        return get(options, getTypeReference<T>())
    }


    fun <T> get(
        options: RequestOptions,
        dto: TypeReference<T>
    ): Pair<T, Response> {
        return baseRequest(
            fuel.get(buildRequestUrl(baseUrl, options)),
            options,
            dto
        )
    }

    inline fun <reified T> put(
        options: RequestOptions,
        dto: Class<T>
    ): Pair<T, Response> {
        return put(options, getTypeReference<T>())
    }

    fun <T> put(
        options: RequestOptions,
        dto: TypeReference<T>
    ): Pair<T, Response> {
        val body = objectMapper.writeValueAsString(options.params.body)
        return baseRequest(
            fuel.put(buildRequestUrl(baseUrl, options)).body(body),
            options,
            dto
        )
    }
}