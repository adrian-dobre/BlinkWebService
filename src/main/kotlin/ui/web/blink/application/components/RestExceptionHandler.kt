/*
 * Copyright (c) 2020 Adrian Dobre - GPL v3 License.
 *
 * This file is subject to the terms and conditions defined in
 * the 'LICENSE.txt' file, which is part of this source code package.
 */

package ui.web.blink.application.components

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.ServletWebRequest
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import ui.web.blink.infrastructure.helpers.BaseServiceUnauthorizedException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@ControllerAdvice
class RestExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(BaseServiceUnauthorizedException::class)
    fun handleException(exception: BaseServiceUnauthorizedException, webRequest: WebRequest): ResponseEntity<Any> {
        val servletRequest: ServletWebRequest = webRequest as ServletWebRequest
        return handleExceptionInternal(exception, hashMapOf(
            "error" to HttpStatus.UNAUTHORIZED.name,
            "message" to exception.message,
            "path" to servletRequest.request.requestURI,
            "status" to HttpStatus.UNAUTHORIZED.value(),
            "timestamp" to LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
        ), HttpHeaders(), HttpStatus.UNAUTHORIZED, webRequest)
    }
}