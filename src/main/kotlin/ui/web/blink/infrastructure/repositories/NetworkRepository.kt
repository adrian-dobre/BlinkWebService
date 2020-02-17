package ui.web.blink.infrastructure.repositories

import ui.web.blink.domain.entities.Camera
import ui.web.blink.domain.entities.CommandStatus
import ui.web.blink.domain.entities.Program
import ui.web.blink.domain.entities.Signal

interface NetworkRepository {
    fun getProgramList(authKey: String, regionId: String, networkId: Int): List<Program>
    fun getNetworkCameraConfig(authKey: String, regionId: String, networkId: Int, cameraId: Int): Camera
    fun getNetworkCameraSignals(authKey: String, regionId: String, networkId: Int, cameraId: Int): Signal
    fun getNetworkCommandSatus(authKey: String, regionId: String, networkId: Int, commandId: Int): CommandStatus
}