package ui.web.blink.infrastructure.repositories

import com.github.kittinunf.fuel.core.Response
import ui.web.blink.domain.aggregates.HomeScreen
import ui.web.blink.domain.aggregates.PagedMediaList
import ui.web.blink.domain.entities.AccountOptions
import ui.web.blink.domain.entities.Notifications
import ui.web.blink.domain.entities.Program

interface MediaRepository {
    fun getMedia(authKey: String, regionId: String, mediaPath: String): Pair<String, Response>
}