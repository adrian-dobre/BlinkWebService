/*
 * Copyright (c) 2020 Adrian Dobre - GPL v3 License.
 *
 * This file is subject to the terms and conditions defined in
 * the 'LICENSE.txt' file, which is part of this source code package.
 */

package ui.web.blink.domain.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonRootName

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("notifications")
data class Notifications (
    val lowBattery: Boolean,
    val cameraOffline: Boolean,
    val cameraUsage: Boolean,
    val scheduling: Boolean,
    val motion: Boolean,
    val syncModuleOffline: Boolean,
    val temperature: Boolean,
    val doorbell: Boolean,
    val wifi: Boolean,
    val lfr: Boolean,
    val bandwidth: Boolean,
    val batteryDead: Boolean
)