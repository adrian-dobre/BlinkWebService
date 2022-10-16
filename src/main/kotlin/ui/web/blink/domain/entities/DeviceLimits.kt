/*
 * Copyright (c) 2020 Adrian Dobre - GPL v3 License.
 *
 * This file is subject to the terms and conditions defined in
 * the 'LICENSE.txt' file, which is part of this source code package.
 */

package ui.web.blink.domain.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class DeviceLimits(
    val totalDevices: Int,
    val owl: Int,
    val camera: Long,
    val siren: Int,
    val doorbellButton: Int,
    val chime: Int
)