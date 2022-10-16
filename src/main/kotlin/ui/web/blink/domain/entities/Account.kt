/*
 * Copyright (c) 2020 Adrian Dobre - GPL v3 License.
 *
 * This file is subject to the terms and conditions defined in
 * the 'LICENSE.txt' file, which is part of this source code package.
 */

package ui.web.blink.domain.entities

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
data class Account (
    val id: Long,
    val verificationRequired: Boolean?,
    val newAccount: Boolean?,
    val emailVerified: Boolean?,
    val emailVerificationRequired: Boolean?,
    val email: String?,
    val timeZone: TimeZone?,
    val owner: Boolean?,
    val name: String?,
    val userAccess: String?,
    val tempUnits: String?,
    val type: String?,
    val pinFailures: Int?,
    val accountId: Long?,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssX")
    val createdAt: Date?,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssX")
    val updatedAt: Date?
)