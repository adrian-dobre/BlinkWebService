package ui.web.blink.application.controllers

import ui.web.blink.domain.entities.Session
import ui.web.blink.infrastructure.repositories.AuthRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ui.web.blink.domain.entities.Login

@RestController
class AuthController {
    @Autowired
    private lateinit var authRepository: AuthRepository

    @PostMapping("/auth/login")
    fun login(@RequestBody login: Login): Session {
        return authRepository.login(login)
    }
}