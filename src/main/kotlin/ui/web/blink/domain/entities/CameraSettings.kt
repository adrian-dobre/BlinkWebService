/*
 * Copyright (c) 2020 Adrian Dobre - GPL v3 License.
 *
 * This file is subject to the terms and conditions defined in
 * the 'LICENSE.txt' file, which is part of this source code package.
 */

package ui.web.blink.domain.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class CameraSettings(
    val videoLength: Int?,
    val videoQuality: String?,
    val recordAudioEnable: Boolean?,
    val earlyTermination: Boolean?,
    val illuminatorEnable: Int?,
    val illuminatorIntensity: Int?,
    val lfrSyncInterval: Int?,
    val name: String?,
    val earlyNotification: Boolean?,
    val motionSensitivity: Int?,
    val motionAlert: Boolean?,
    val alertInterval: Int?
)