/*
 * Copyright (c) 2020 Adrian Dobre - GPL v3 License.
 *
 * This file is subject to the terms and conditions defined in
 * the 'LICENSE.txt' file, which is part of this source code package.
 */

package ui.web.blink.infrastructure.repositories.impl.blink

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component
import ui.web.blink.domain.entities.ClientVerification
import ui.web.blink.domain.entities.Login
import ui.web.blink.domain.entities.Pin
import ui.web.blink.domain.entities.Session
import ui.web.blink.infrastructure.helpers.*
import ui.web.blink.infrastructure.repositories.AuthRepository
import javax.annotation.PostConstruct


data class BlinkLogin(
    val email: String,
    val password: String,
    val appVersion: String,
    val clientName: String,
    val clientType: String,
    val deviceIdentifier: String,
    val notificationKey: String,
    val osVersion: String,
    val uniqueId: String
)

@Component
class AuthRepositoryImpl : AuthRepository {
    @Value("\${blink.serverUrl}")
    lateinit var blinkUrl: String

    @Autowired
    lateinit var environment: Environment

    @Autowired
    lateinit var commonHeaders: CommonHeaders
    private lateinit var baseService: BaseService

    @PostConstruct
    fun init() {
        baseService = BaseService("https://rest-prod.${blinkUrl}/api", commonHeaders)
    }

    override fun login(login: Login): Session {
        return baseService.post(
            RequestOptions(
                path = "v4/account/login",
                params = RequestParams(
                    body = BlinkLogin(
                        login.email,
                        login.password,
                        environment.getRequiredProperty("blink.app-info.app-version"),
                        environment.getRequiredProperty("blink.app-info.client_name"),
                        environment.getRequiredProperty("blink.app-info.client_type"),
                        environment.getRequiredProperty("blink.app-info.device_identifier"),
                        environment.getRequiredProperty("blink.app-info.notification_key"),
                        environment.getRequiredProperty("blink.app-info.os_version"),
                        environment.getRequiredProperty("blink.app-info.unique_id")
                    )
                )
            ),
            Session::class.java
        ).body
    }

    override fun verifyClient(
        authKey: String,
        regionId: String,
        accountId: Int,
        clientId: Int,
        pin: Pin
    ): ClientVerification {
        return RegionalBaseServiceClient(regionId, blinkUrl, commonHeaders).post(
            RegionalBaseServiceClient.requestOptionsAuthKey(
                authKey, RequestOptions(
                    path = "api/v4/account/${accountId}/client/${clientId}/pin/verify",
                    params = RequestParams(
                        body = pin
                    )
                )
            ),
            ClientVerification::class.java
        ).body
    }

    override fun logout(
        authKey: String,
        regionId: String,
        accountId: Int,
        clientId: Int
    ) {
        RegionalBaseServiceClient(regionId, blinkUrl, commonHeaders).post(
            RegionalBaseServiceClient.requestOptionsAuthKey(
                authKey, RequestOptions(
                    path = "api/v4/account/${accountId}/client/${clientId}/logout"
                )
            ),
            Any::class.java
        ).body
    }
}