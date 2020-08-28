/*
 * Copyright (c) 2020 Adrian Dobre - GPL v3 License.
 *
 * This file is subject to the terms and conditions defined in
 * the 'LICENSE.txt' file, which is part of this source code package.
 */

package ui.web.blink.infrastructure.helpers

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.github.kittinunf.fuel.core.*
import com.github.kittinunf.result.Result
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.net.URLEncoder

class BaseServiceUnauthorizedException(message: String?) : Exception(message)

data class RequestParams(
    var query: MutableMap<String, String> = mutableMapOf(),
    var body: Any? = null
)

data class RequestOptions(
    var params: RequestParams = RequestParams(),
    var headers: MutableMap<String, String> = mutableMapOf(),
    var path: String? = null,
    var timeout: Int = 60000
)

data class BaseServiceResult<T>(
    val response: Response,
    val body: T
)

enum class BodyMapper {
    NONE,
    XML,
    JSON,
    JSON_SNAKE
}

open class BaseService(
    private val baseUrl: String,
    private val commonHeaders: CommonHeaders,
    private val requestBodyMapper: BodyMapper = BodyMapper.JSON_SNAKE,
    private val responseBodyMapper: BodyMapper = BodyMapper.JSON_SNAKE
) {

    private val logger: Logger = LoggerFactory.getLogger(BaseService::class.java)
    var fuel: FuelManager = FuelManager()

    private fun getBodyMapper(bodyMapper: BodyMapper): ObjectMapper? {
        return when (bodyMapper) {
            BodyMapper.XML -> XmlMapper().registerModule(KotlinModule())
            BodyMapper.JSON -> ObjectMapper().registerModule(KotlinModule())
            BodyMapper.JSON_SNAKE -> {
                val mapper = ObjectMapper().registerModule(KotlinModule())
                mapper.propertyNamingStrategy = PropertyNamingStrategy.SNAKE_CASE
                mapper
            }
            else -> null
        }
    }

    private fun mapRequestBody(body: Any?): String {
        return if (body != null) {
            val mapper = getBodyMapper(requestBodyMapper);
            if (mapper != null) {
                mapper.writeValueAsString(body)
            } else {
                body as String
            }
        } else {
            ""
        }
    }

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
    ): BaseServiceResult<T> {
        when (response) {
            is Result.Failure -> {
                throw response.getException()
            }
            is Result.Success -> {
                val mapper = getBodyMapper(responseBodyMapper)
                val bodyData = response.get()

                if (bodyData.isEmpty()) {
                    return BaseServiceResult(
                        response = rawResponse,
                        body = bodyData as T
                    )
                }

                return if (mapper != null) {
                    BaseServiceResult(
                        response = rawResponse,
                        body = mapper.readValue(bodyData, dto)
                    )
                } else {
                    BaseServiceResult(
                        response = rawResponse,
                        body = bodyData as T
                    )
                }
            }
        }
    }

    protected fun <T> baseRequest(
        request: Request,
        options: RequestOptions,
        dto: TypeReference<T>
    ): BaseServiceResult<T> {
        val headersCopy: MutableMap<String, String> = commonHeaders.addCommonHeaders(options.headers.toMutableMap())

        val (_, response, result) = request
            .header(headersCopy)
            .responseString()

        if (response.statusCode !in 200..299) {
            if (response.statusCode in listOf(401, 403)) {
                throw BaseServiceUnauthorizedException("Unauthorized. Details: \n $response")
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
            baseUrlCopy += "$separator${queryParam.key}=${URLEncoder.encode(queryParam.value, "UTF-8")}"
        }
        return baseUrlCopy
    }

    inline fun <reified T> getTypeReference(): TypeReference<T> {
        return object : TypeReference<T>() {}
    }

    inline fun <reified T> post(
        options: RequestOptions,
        dto: Class<T>
    ): BaseServiceResult<T> {
        return post(options, getTypeReference<T>())
    }

    fun <T> post(
        options: RequestOptions,
        dto: TypeReference<T>
    ): BaseServiceResult<T> {
        return baseRequest(
            fuel
                .post(buildRequestUrl(baseUrl, options))
                .timeout(options.timeout)
                .timeoutRead(options.timeout)
                .body(mapRequestBody(options.params.body)),
            options,
            dto
        )
    }

    inline fun <reified T> get(
        options: RequestOptions,
        dto: Class<T>
    ): BaseServiceResult<T> {
        return get(options, getTypeReference<T>())
    }


    fun <T> get(
        options: RequestOptions,
        dto: TypeReference<T>
    ): BaseServiceResult<T> {
        return baseRequest(
            fuel
                .get(buildRequestUrl(baseUrl, options))
                .timeout(options.timeout)
                .timeoutRead(options.timeout),
            options,
            dto
        )
    }

    inline fun <reified T> put(
        options: RequestOptions,
        dto: Class<T>
    ): BaseServiceResult<T> {
        return put(options, getTypeReference<T>())
    }

    fun <T> put(
        options: RequestOptions,
        dto: TypeReference<T>
    ): BaseServiceResult<T> {

        return baseRequest(
            fuel
                .put(buildRequestUrl(baseUrl, options))
                .timeout(options.timeout)
                .timeoutRead(options.timeout)
                .body(mapRequestBody(options.params.body)),
            options,
            dto
        )
    }

    inline fun <reified T> delete(
        options: RequestOptions,
        dto: Class<T>
    ): BaseServiceResult<T> {
        return delete(options, getTypeReference<T>())
    }

    fun <T> delete(
        options: RequestOptions,
        dto: TypeReference<T>
    ): BaseServiceResult<T> {

        return baseRequest(
            fuel
                .delete(buildRequestUrl(baseUrl, options))
                .timeout(options.timeout)
                .timeoutRead(options.timeout)
                .body(mapRequestBody(options.params.body)),
            options,
            dto
        )
    }
}