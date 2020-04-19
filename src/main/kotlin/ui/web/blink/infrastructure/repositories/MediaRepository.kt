package ui.web.blink.infrastructure.repositories

import ui.web.blink.infrastructure.helpers.BaseServiceResult

interface MediaRepository {
    fun getMedia(authKey: String, regionId: String, mediaPath: String): BaseServiceResult<String>
}