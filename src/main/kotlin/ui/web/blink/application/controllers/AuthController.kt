/*
 * Copyright (c) 2020 Adrian Dobre - GPL v3 License.
 *
 * This file is subject to the terms and conditions defined in
 * the 'LICENSE.txt' file, which is part of this source code package.
 */

package ui.web.blink.application.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ui.web.blink.domain.entities.Login
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
}