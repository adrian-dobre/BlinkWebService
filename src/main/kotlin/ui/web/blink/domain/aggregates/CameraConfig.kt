package ui.web.blink.domain.aggregates

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import ui.web.blink.domain.entities.Camera
import ui.web.blink.domain.entities.Signal

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
@JsonIgnoreProperties(ignoreUnknown = true)
data class CameraConfig (
    val camera: List<Camera>,
    val signals: Signal
)