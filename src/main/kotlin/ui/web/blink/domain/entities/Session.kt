/*
 * Copyright (c) 2020 Adrian Dobre - GPL v3 License.
 *
 * This file is subject to the terms and conditions defined in
 * the 'LICENSE.txt' file, which is part of this source code package.
 */

package ui.web.blink.domain.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import ui.web.blink.infrastructure.helpers.deserializers.NetworksDeserializer

@JsonIgnoreProperties(ignoreUnknown = true)
data class Session(
    @JsonProperty("authtoken")
    val authToken: AuthToken,
    val account: Account,
    val client: Client,
    @JsonDeserialize(using = NetworksDeserializer::class)
    val networks: List<Network>?,
//    @JsonDeserialize(using = RegionDeserializer::class)
    val region: Region
)