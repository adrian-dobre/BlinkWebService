/*
 * Copyright (c) 2020 Adrian Dobre - GPL v3 License.
 *
 * This file is subject to the terms and conditions defined in
 * the 'LICENSE.txt' file, which is part of this source code package.
 */

package ui.web.blink.domain.aggregates

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import ui.web.blink.domain.entities.*

@JsonIgnoreProperties(ignoreUnknown = true)
data class HomeScreen (
    val account: Account,
    val networks: List<Network>,
    val syncModules: List<SyncModule>,
    val cameras: List<Camera>,
    val videoStats: VideoStats,
    val deviceLimits: DeviceLimits
)