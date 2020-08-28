/*
 * Copyright (c) 2020 Adrian Dobre - GPL v3 License.
 *
 * This file is subject to the terms and conditions defined in
 * the 'LICENSE.txt' file, which is part of this source code package.
 */

package ui.web.blink.infrastructure.repositories.impl.blink

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import ui.web.blink.infrastructure.helpers.BaseServiceResult
import ui.web.blink.infrastructure.helpers.CommonHeaders
import ui.web.blink.infrastructure.helpers.RegionalMediaServiceClient
import ui.web.blink.infrastructure.helpers.RequestOptions
import ui.web.blink.infrastructure.repositories.MediaRepository

@Component
class MediaRepositoryImpl : MediaRepository {
    @Value("\${blink.serverUrl}")
    lateinit var blinkUrl: String

    @Autowired
    lateinit var commonHeaders: CommonHeaders

    override fun getMedia(authKey: String, regionId: String, mediaPath: String): BaseServiceResult<String> {

        return RegionalMediaServiceClient(regionId, blinkUrl, commonHeaders)
            .get(
                RegionalMediaServiceClient.requestOptionsAuthKey(
                    authKey, RequestOptions(
                        path = mediaPath
                    )
                ),
                String::class.java
            )
    }
}