package ui.web.blink.domain.aggregates

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import ui.web.blink.domain.entities.*

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
@JsonIgnoreProperties(ignoreUnknown = true)
data class HomeScreen (
    val account: Account,
    val networks: List<Network>,
    val syncModules: List<SyncModule>,
    val cameras: List<Camera>,
    val videoStats: VideoStats,
    val deviceLimits: DeviceLimits
)