/*
 * Copyright (c) 2020 Adrian Dobre - GPL v3 License.
 *
 * This file is subject to the terms and conditions defined in
 * the 'LICENSE.txt' file, which is part of this source code package.
 */

package ui.web.blink.domain.entities

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
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

@JsonIgnoreProperties(ignoreUnknown = true)
data class Schedule(
    @JsonProperty("dow")
    val dayOfWeek: List<DayOfWeek>,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ssX")
    val time: Date? = null,
    val action: Action
)