/*
 * Copyright (c) 2020 Adrian Dobre - GPL v3 License.
 *
 * This file is subject to the terms and conditions defined in
 * the 'LICENSE.txt' file, which is part of this source code package.
 */

package ui.web.blink.domain.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class CommandStatus (
    val id: Long?,
    val command: String?,
    val state: String?,
    val complete: Boolean?,
    val status: Int?,
    val statusMsg: String?,
    val statusCode: Int?,
    val mediaId: Long?,
    val commands: List<Command>?
)