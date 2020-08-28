package ui.web.blink.infrastructure.helpers

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class CommonHeaders {
    @Value("\${blink.app-headers.accept-language}")
    lateinit var acceptLanguage: String

    @Value("\${blink.app-headers.app-build}")
    lateinit var appBuild: String

    @Value("\${blink.app-headers.locale}")
    lateinit var locale: String

    @Value("\${blink.app-headers.user-agent}")
    lateinit var userAgent: String

    fun addCommonHeaders(headers: MutableMap<String, String>): MutableMap<String, String> {
        headers["accept-language"] = acceptLanguage
        headers["app-build"] = appBuild
        headers["locale"] = locale
        headers["user-agent"] = userAgent
        return headers
    }
}