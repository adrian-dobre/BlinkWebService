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
data class CameraLastConnect(
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssX")
    val createdAt: Date,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssX")
    val cameraId: Int?,
    val wifiStrength: Int?,
    val lfrStrength: Int?,
    val batteryVoltage: Int?,
    val temperature: Int?,
    val fwVersion: String?,
    val fwGitHash: String?,
    val mac: String?,
    val ipv: String?,
    val ipAddress: String?,
    val errorCodes: Int?,
    val batteryAlertStatus: Boolean?,
    val tempAlertStatus: Boolean?,
    val acPower: Boolean?,
    val lightSensorCh0: Int?,
    val lightSensorCh1: Int?,
    val lightSensorDataValid: Boolean?,
    val lightSensorDataNew: Boolean?,
    val timeFirstVideo: Int?,
    val time108Boot: Int?,
    val timeWlanConnect: Int?,
    val timeDhcpLease: Int?,
    val timeDnsResolve: Int?,
    val lfr108Wakeups: Int?,
    val total108Wakeups: Int?,
    val lfrTbWakeups: Int?,
    val totalTbWakeups: Int?,
    val wifiConnectFailureCount: Int?,
    val dhcpFailureCount: Int?,
    val socketFailureCount: Int?,
    val dev1: Int?,
    val dev2: Int?,
    val dev3: Int?,
    val unitNumber: Int?,
    val serial: String?,
    val lifetimeCount: Int?,
    val lifetimeDuration: Int?,
    val pirRejections: Int?,
    val syncModuleId: Int?,
    val networkId: Int?,
    val accountId: Int?
)
