/*
 * Copyright (c) 2020 Adrian Dobre - GPL v3 License.
 *
 * This file is subject to the terms and conditions defined in
 * the 'LICENSE.txt' file, which is part of this source code package.
 */

package ui.web.blink.domain.entities

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
data class Camera(
    val id: Long,
    val name: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssX")
    val createdAt: Date,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssX")
    val updatedAt: Date,
    val status: String,
    val serial: String,
    val fwVersion: String,
    val networkId: Long,
    val type: String,
    val enabled: Boolean,
    val thumbnail: String,
    val battery: String?,
    val usageRate: Boolean,
    var signals: Signal?,
    val cameraKey: String?,
    @JsonProperty("liveview_enabled")
    val liveViewEnabled: String?,
    val sirenEnabled: Boolean?,
    val onboarded: Boolean?,
    val unitNumber: Int?,
    val motionSensitivity: Double?,
    val alertToneEnabled: Boolean?,
    val alertToneVolume: Int?,
    val alertRepeat: String?,
    val alertInterval: Int?,
    val videoLength: Int?,
    val tempAlarmEnable: Boolean?,
    val tempInterval: Int?,
    val tempAdjust: Int?,
    val tempMin: Int?,
    val tempMax: Int?,
    val illuminatiorEnable: Int?,
    val illuminatorDuration: Int?,
    val illuminatorIntensity: Int?,
    val batteryAlarmEnable: Boolean?,
    val batteryVoltageInterval: Int?,
    val batteryVoltageThreshold: Int?,
    val batteryVoltageHysteresis: Int?,
    val batteryAlertCount: Int?,
    val lftSyncInterval: Int?,
    val video5060hz: String?,
    val invertImage: Boolean?,
    val flipImage: Boolean?,
    val recordAudioEnable: Boolean?,
    val clipRate: Int?,
    @JsonProperty("liveview_rate")
    val liveViewRate: Int?,
    val maxResolution: String?,
    val autoTest: Boolean?,
    val wifiTimeout: Int?,
    val retryCount: Int?,
    val wifiStrength: Int?,
    val lfrStrength: Int?,
    val temperature: Int?,
    val batteryVoltage: Int?,
    val a1: Boolean?,
    val tempAlertCount: Int?,
    val wifiAlertCount: Int?,
    val lfrAlertCount: Int?,
    val offlineAlertCount: Int?,
    val tempAlertState: String?,
    val batteryState: String?,
    val batteryCheckTime: String?,
    val motionRegions: Int?,
    val mfgMainType: String?,
    val mfgMainRange: Int?,
    val mfgMezType: String?,
    val mfgMezRange: Int?,
    val accountId: Long?,
    val syncModuleId: Long?,
    val account: Long?,
    val network: Long?,
    val cameraSeq: Int?,
    val lastConnect: CameraLastConnect?,
    val motionAlert: Boolean?,
    val recordAudio: Boolean?,
    val buzzerOn: Boolean?,
    val earlyTermination: Boolean?,
    val clipBitrate: Int?,
    val liveviewBitrate: Int?,
    val motionRegionsCompatible: Boolean?,
    val earlyPirCompatible: Boolean?,
    val earlyNotificationCompatible: Boolean?,
    val nightVisionExposureCompatible: Boolean?,
    val videoQualitySupport: List<String>?,
    val videoQuality: String?,
    val earlyNotification: Boolean?,
    val nightVisionExposure: Int?,
    val clipMaxLength: Int?,
    val earlyTerminationSupported: Boolean?,
    val clipWarningThreshold: Int?
)