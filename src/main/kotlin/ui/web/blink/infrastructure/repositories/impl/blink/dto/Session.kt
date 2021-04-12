/*
 * Copyright (c) 2021 Adrian Dobre - GPL v3 License.
 *
 * This file is subject to the terms and conditions defined in
 * the 'LICENSE.txt' file, which is part of this source code package.
 */

package ui.web.blink.infrastructure.repositories.impl.blink.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Session(
    val auth: Auth,
    val account: Account,
    val lockoutTimeRemaining: Int,
    val forcePasswordReset: Boolean,
    val allowPinResendSeconds: Int
)