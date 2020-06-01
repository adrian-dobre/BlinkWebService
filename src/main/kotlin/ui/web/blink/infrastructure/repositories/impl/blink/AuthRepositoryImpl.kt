/*
 * Copyright (c) 2020 Adrian Dobre - GPL v3 License.
 *
 * This file is subject to the terms and conditions defined in
 * the 'LICENSE.txt' file, which is part of this source code package.
 */

package ui.web.blink.infrastructure.repositories.impl.blink

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import ui.web.blink.domain.entities.Login
import ui.web.blink.domain.entities.Session
import ui.web.blink.infrastructure.helpers.BaseService
import ui.web.blink.infrastructure.helpers.RequestOptions
import ui.web.blink.infrastructure.helpers.RequestParams
import ui.web.blink.infrastructure.repositories.AuthRepository
import javax.annotation.PostConstruct

@Component
class AuthRepositoryImpl : AuthRepository {
    @Value("\${blink.serverUrl}")
    lateinit var blinkUrl: String
    private lateinit var baseService: BaseService;

    @PostConstruct
    fun init() {
        baseService = BaseService("https://rest-prod.${blinkUrl}/api");
    }


    override fun login(login: Login): Session {
        return baseService.post(
            RequestOptions(
                path = "v4/account/login",
                params = RequestParams(
                    body = login
                )
            ),
            Session::class.java
        ).body
    }

    override fun logout() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}