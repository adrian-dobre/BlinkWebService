package ui.web.blink.domain.entities

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.util.*

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Media (
    val id: Int,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssX")
    val createdAt: Date? = null,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssX")
    val updatedAt: Date? = null,
    val deleted: Boolean,
    val device: String,
    val deviceId: Int,
    val deviceName: String,
    val networkId: Int,
    val networkName: String,
    val type: String,
    val source: String,
    val watched: Boolean,
    val partial: Boolean,
    val thumbnail: String,
    val media: String,
    val timeZone: TimeZone
)