package ui.web.blink.infrastructure.repositories

import com.github.kittinunf.fuel.core.Response

interface MediaRepository {
    fun getMedia(authKey: String, regionId: String, mediaPath: String): Pair<String, Response>
}