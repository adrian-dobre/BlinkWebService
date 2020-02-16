package ui.web.blink.domain.aggregates

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import ui.web.blink.domain.entities.Media

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
@JsonIgnoreProperties(ignoreUnknown = true)
data class PagedMediaList (
    val limit: Int,
    val purgeId: Int,
    val refreshCount: Int,
    val media: List<Media>
)