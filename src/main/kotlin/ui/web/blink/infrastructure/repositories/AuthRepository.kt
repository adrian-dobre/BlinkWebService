package ui.web.blink.infrastructure.repositories

import ui.web.blink.domain.entities.Login
import ui.web.blink.domain.entities.Session

interface AuthRepository {
    fun login(login: Login): Session
    fun logout()
}