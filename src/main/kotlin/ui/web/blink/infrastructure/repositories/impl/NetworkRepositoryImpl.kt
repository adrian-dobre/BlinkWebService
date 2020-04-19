package ui.web.blink.infrastructure.repositories.impl

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import ui.web.blink.domain.aggregates.CameraConfig
import ui.web.blink.domain.entities.Camera
import ui.web.blink.domain.entities.CommandStatus
import ui.web.blink.domain.entities.Program
import ui.web.blink.domain.entities.Signal
import ui.web.blink.infrastructure.helpers.RegionalBaseService
import ui.web.blink.infrastructure.helpers.RequestOptions
import ui.web.blink.infrastructure.repositories.NetworkRepository

@Component
class NetworkRepositoryImpl : NetworkRepository {
    @Value("\${blink.serverUrl}")
    lateinit var blinkUrl: String

    override fun getProgramList(authKey: String, regionId: String, networkId: Int): List<Program> {
        val regionalBaseService = RegionalBaseService(regionId, blinkUrl)
        return regionalBaseService.get(
            RegionalBaseService.requestOptionsAuthKey(
                authKey, RequestOptions(
                    path = "api/v1/networks/${networkId}/programs"
                )
            ),
            regionalBaseService.getTypeReference<List<Program>>()
        ).first
    }

    override fun getNetworkCameraConfig(authKey: String, regionId: String, networkId: Int, cameraId: Int): Camera {
        val regionalBaseService = RegionalBaseService(regionId, blinkUrl)
        val cameraConfig =  regionalBaseService.get(
            RegionalBaseService.requestOptionsAuthKey(
                authKey, RequestOptions(
                    path = "network/${networkId}/camera/${cameraId}/config"
                )
            ),
            CameraConfig::class.java
        ).first;
        val camera = cameraConfig.camera[0];
        camera.signals = cameraConfig.signals
        return camera
    }

    override fun getNetworkCameraSignals(authKey: String, regionId: String, networkId: Int, cameraId: Int): Signal {
        return RegionalBaseService(regionId, blinkUrl).get(
            RegionalBaseService.requestOptionsAuthKey(
                authKey, RequestOptions(
                    path = "network/${networkId}/camera/${cameraId}/signals"
                )
            ),
           Signal::class.java
        ).first
    }

    override fun getNetworkCommandSatus(authKey: String, regionId: String, networkId: Int, commandId: Int): CommandStatus {
        return RegionalBaseService(regionId, blinkUrl).get(
            RegionalBaseService.requestOptionsAuthKey(
                authKey, RequestOptions(
                    path = "network/${networkId}/command/${commandId}"
                )
            ),
            CommandStatus::class.java
        ).first
    }
}