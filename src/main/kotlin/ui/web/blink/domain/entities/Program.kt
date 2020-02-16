package ui.web.blink.domain.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Program (
    val id: Int,
    val networkId: Int,
    val status: String,
    val name: String,
    val format: String,
    val schedule: List<Schedule>
)