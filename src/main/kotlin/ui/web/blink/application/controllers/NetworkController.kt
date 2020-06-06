/*
 * Copyright (c) 2020 Adrian Dobre - GPL v3 License.
 *
 * This file is subject to the terms and conditions defined in
 * the 'LICENSE.txt' file, which is part of this source code package.
 */

package ui.web.blink.application.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ui.web.blink.domain.entities.*
import ui.web.blink.infrastructure.repositories.NetworkRepository

@CrossOrigin
@RestController
class NetworkController {
    @Autowired
    private lateinit var networkRepository: NetworkRepository


    @GetMapping("/regions/{regionId}/networks/{networkId}/programs")
    fun getProgramList(
        @PathVariable regionId: String,
        @PathVariable networkId: Int,
        @RequestHeader("authToken") authKey: String
    ): List<Program> {
        return networkRepository.getProgramList(authKey, regionId, networkId)
    }

    @GetMapping("/regions/{regionId}/networks/{networkId}/cameras/{cameraId}/config")
    fun getNetworkCameras(
        @PathVariable regionId: String,
        @PathVariable networkId: Int,
        @PathVariable cameraId: Int,
        @RequestHeader("authToken") authKey: String
    ): Camera {
        return networkRepository.getNetworkCameraConfig(authKey, regionId, networkId, cameraId)
    }

    @GetMapping("/regions/{regionId}/networks/{networkId}/cameras/{cameraId}/signals")
    fun getNetworkCameraSignals(
        @PathVariable regionId: String,
        @PathVariable networkId: Int,
        @PathVariable cameraId: Int,
        @RequestHeader("authToken") authKey: String
    ): Signal {
        return networkRepository.getNetworkCameraSignals(authKey, regionId, networkId, cameraId)
    }

    @GetMapping("/regions/{regionId}/networks/{networkId}/commands/{commandId}")
    fun getNetworkCommand(
        @PathVariable regionId: String,
        @PathVariable networkId: Int,
        @PathVariable commandId: Int,
        @RequestHeader("authToken") authKey: String
    ): CommandStatus {
        return networkRepository.getNetworkCommandStatus(authKey, regionId, networkId, commandId)
    }

    @PutMapping("/regions/{regionId}/networks/{networkId}/cameras/{cameraId}/settings")
    fun updateNetworkCameraSettings(
        @PathVariable regionId: String,
        @PathVariable networkId: Int,
        @PathVariable cameraId: Int,
        @RequestBody cameraSettings: CameraSettings,
        @RequestHeader("authToken") authKey: String
    ): CommandStatus {
        return networkRepository.updateNetworkCameraSettings(authKey, regionId, networkId, cameraId, cameraSettings)
    }
}