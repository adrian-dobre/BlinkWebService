package ui.web.blink.infrastructure.repositories

import ui.web.blink.domain.aggregates.HomeScreen
import ui.web.blink.domain.aggregates.PagedMediaList
import ui.web.blink.domain.entities.AccountOptions
import ui.web.blink.domain.entities.Notifications
import ui.web.blink.domain.entities.Program

interface NetworkRepository {
    fun getProgramList(authKey: String, regionId: String, networkId: Int): List<Program>
}