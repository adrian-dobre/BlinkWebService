package ui.web.blink.infrastructure.repositories.impl

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import ui.web.blink.infrastructure.helpers.BaseServiceResult
import ui.web.blink.infrastructure.helpers.RegionalMediaServiceClient
import ui.web.blink.infrastructure.helpers.RequestOptions
import ui.web.blink.infrastructure.repositories.MediaRepository

@Component
class MediaRepositoryImpl : MediaRepository {
    @Value("\${blink.serverUrl}")
    lateinit var blinkUrl: String

    override fun getMedia(authKey: String, regionId: String, mediaPath: String): BaseServiceResult<String> {

        return RegionalMediaServiceClient(regionId, blinkUrl)
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