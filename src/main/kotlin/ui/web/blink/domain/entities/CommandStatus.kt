package ui.web.blink.domain.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
@JsonIgnoreProperties(ignoreUnknown = true)
data class CommandStatus (
    val complete: Boolean,
    val status: Int,
    val statusMsg: String,
    val statusCode: Int,
    val mediaId: Int?,
    val commands: List<Command>
)