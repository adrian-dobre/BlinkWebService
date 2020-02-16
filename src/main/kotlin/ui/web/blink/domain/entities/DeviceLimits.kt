package ui.web.blink.domain.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.sql.Time

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
@JsonIgnoreProperties(ignoreUnknown = true)
data class DeviceLimits(
    val totalDevices: Int,
    val owl: Int,
    val camera: Int,
    val siren: Int,
    val doorbellButton: Int,
    val chime: Int
)