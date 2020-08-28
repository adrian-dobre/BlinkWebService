/*
 * Copyright (c) 2020 Adrian Dobre - GPL v3 License.
 *
 * This file is subject to the terms and conditions defined in
 * the 'LICENSE.txt' file, which is part of this source code package.
 */

package ui.web.blink.infrastructure.repositories.impl.blink

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import ui.web.blink.domain.aggregates.CameraConfig
import ui.web.blink.domain.entities.*
import ui.web.blink.infrastructure.helpers.CommonHeaders
import ui.web.blink.infrastructure.helpers.RegionalBaseServiceClient
import ui.web.blink.infrastructure.helpers.RequestOptions
import ui.web.blink.infrastructure.helpers.RequestParams
import ui.web.blink.infrastructure.repositories.NetworkRepository

@Component
class NetworkRepositoryImpl : NetworkRepository {
    @Value("\${blink.serverUrl}")
    lateinit var blinkUrl: String

    @Autowired
    lateinit var commonHeaders: CommonHeaders

    override fun getProgramList(authKey: String, regionId: String, networkId: Int): List<Program> {
        val regionalBaseService = RegionalBaseServiceClient(regionId, blinkUrl, commonHeaders)
        return regionalBaseService.get(
            RegionalBaseServiceClient.requestOptionsAuthKey(
                authKey, RequestOptions(
                    path = "api/v1/networks/${networkId}/programs"
                )
            ),
            regionalBaseService.getTypeReference<List<Program>>()
        ).body
    }

    override fun getNetworkCameraConfig(authKey: String, regionId: String, networkId: Int, cameraId: Int): Camera {
        val regionalBaseService = RegionalBaseServiceClient(regionId, blinkUrl, commonHeaders)
        val cameraConfig = regionalBaseService.get(
            RegionalBaseServiceClient.requestOptionsAuthKey(
                authKey, RequestOptions(
                    path = "network/${networkId}/camera/${cameraId}/config"
                )
            ),
            CameraConfig::class.java
        ).body
        val camera = cameraConfig.camera[0];
        camera.signals = cameraConfig.signals
        return camera
    }

    override fun getNetworkCameraSignals(authKey: String, regionId: String, networkId: Int, cameraId: Int): Signal {
        return RegionalBaseServiceClient(regionId, blinkUrl, commonHeaders).get(
            RegionalBaseServiceClient.requestOptionsAuthKey(
                authKey, RequestOptions(
                    path = "network/${networkId}/camera/${cameraId}/signals"
                )
            ),
            Signal::class.java
        ).body
    }

    override fun getNetworkCommandStatus(
        authKey: String,
        regionId: String,
        networkId: Int,
        commandId: Int
    ): CommandStatus {
        return RegionalBaseServiceClient(regionId, blinkUrl, commonHeaders).get(
            RegionalBaseServiceClient.requestOptionsAuthKey(
                authKey, RequestOptions(
                    path = "network/${networkId}/command/${commandId}"
                )
            ),
            CommandStatus::class.java
        ).body
    }

    override fun updateNetworkCameraSettings(
        authKey: String,
        regionId: String,
        networkId: Int,
        cameraId: Int,
        cameraSettings: CameraSettings
    ): CommandStatus {
        return RegionalBaseServiceClient(regionId, blinkUrl, commonHeaders).post(
            RegionalBaseServiceClient.requestOptionsAuthKey(
                authKey, RequestOptions(
                    path = "network/${networkId}/camera/${cameraId}/update",
                    params = RequestParams(
                        body = cameraSettings
                    )
                )
            ),
            CommandStatus::class.java
        ).body
    }
}