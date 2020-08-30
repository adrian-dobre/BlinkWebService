/*
 * Copyright (c) 2020 Adrian Dobre - GPL v3 License.
 *
 * This file is subject to the terms and conditions defined in
 * the 'LICENSE.txt' file, which is part of this source code package.
 */

package ui.web.blink.infrastructure.repositories

import ui.web.blink.domain.entities.ClientVerification
import ui.web.blink.domain.entities.Login
import ui.web.blink.domain.entities.Pin
import ui.web.blink.domain.entities.Session

interface AuthRepository {
    fun login(login: Login): Session
    fun verifyClient(authKey: String, regionId: String, accountId: Int, clientId: Int, pin: Pin): ClientVerification
    fun logout(
        authKey: String,
        regionId: String,
        accountId: Int,
        clientId: Int
    )
}