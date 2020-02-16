package ui.web.blink.domain.entities

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.util.*

enum class DayOfWeek {
    sun,
    mon,
    tue,
    wed,
    thu,
    fri,
    sat
}

enum class Action {
    arm,
    disarm
}

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Schedule(
    @JsonProperty("dow")
    val dayOfWeek: List<DayOfWeek>,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ssX")
    val time: Date? = null,
    val action: Action
)