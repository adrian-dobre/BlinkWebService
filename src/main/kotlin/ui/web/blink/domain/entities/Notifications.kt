package ui.web.blink.domain.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonRootName
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
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