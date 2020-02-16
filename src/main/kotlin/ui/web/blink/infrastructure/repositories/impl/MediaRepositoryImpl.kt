package ui.web.blink.infrastructure.repositories.impl

import com.github.kittinunf.fuel.core.Response
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import ui.web.blink.domain.entities.Program
import ui.web.blink.infrastructure.helpers.MediaService
import ui.web.blink.infrastructure.helpers.RegionalBaseService
import ui.web.blink.infrastructure.helpers.RegionalMediaService
import ui.web.blink.infrastructure.helpers.RequestOptions
import ui.web.blink.infrastructure.repositories.MediaRepository
import ui.web.blink.infrastructure.repositories.NetworkRepository

@Component
class MediaRepositoryImpl : MediaRepository {
    @Value("\${blink.serverUrl}")
    lateinit var blinkUrl: String

    override fun getMedia(authKey: String, regionId: String, mediaPath: String): Pair<String, Response> {

        return RegionalMediaService(regionId, blinkUrl).get(
            RegionalMediaService.requestOptionsAuthKey(
                authKey, RequestOptions(
                    path = mediaPath
                )
            )
        )
    }
}