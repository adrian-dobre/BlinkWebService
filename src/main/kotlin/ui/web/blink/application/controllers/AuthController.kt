/*
 * Copyright (c) 2020 Adrian Dobre - GPL v3 License.
 *
 * This file is subject to the terms and conditions defined in
 * the 'LICENSE.txt' file, which is part of this source code package.
 */

package ui.web.blink.application.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ui.web.blink.domain.entities.ClientVerification
import ui.web.blink.domain.entities.Login
import ui.web.blink.domain.entities.Pin
import ui.web.blink.domain.entities.Session
import ui.web.blink.infrastructure.repositories.AuthRepository

@CrossOrigin(origins = ["*"])
@RestController
class AuthController {
    @Autowired
    private lateinit var authRepository: AuthRepository

    @PostMapping("/auth/login")
    fun login(@RequestBody login: Login): Session {
        return authRepository.login(login)
    }

    @PostMapping("/regions/{regionId}/accounts/{accountId}/clients/{clientId}/pin/verify")
    fun verifyClient(
        @PathVariable accountId: Int,
        @PathVariable regionId: String,
        @PathVariable clientId: Int,
        @RequestBody pin: Pin,
        @RequestHeader("authToken") authKey: String
    ): ClientVerification {
        return authRepository.verifyClient(authKey, regionId, accountId, clientId, pin)
    }

    @PostMapping("/regions/{regionId}/accounts/{accountId}/clients/{clientId}/logout")
    fun logout(
        @PathVariable accountId: Int,
        @PathVariable regionId: String,
        @PathVariable clientId: Int,
        @RequestHeader("authToken") authKey: String
    ) {
        return authRepository.logout(authKey, regionId, accountId, clientId)
    }
}