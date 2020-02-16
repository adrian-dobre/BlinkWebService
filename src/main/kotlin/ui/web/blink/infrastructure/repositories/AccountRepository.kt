package ui.web.blink.infrastructure.repositories

import ui.web.blink.domain.aggregates.HomeScreen
import ui.web.blink.domain.aggregates.PagedMediaList
import ui.web.blink.domain.entities.AccountOptions
import ui.web.blink.domain.entities.Notifications

interface AccountRepository {
    fun getOptions(authKey: String, regionId: String): AccountOptions
    fun getHomeScreen(authKey: String, regionId: String, accountId: Int): HomeScreen
    fun getNotificationsConfig(authKey: String, regionId: String, accountId: Int): Notifications
    fun getMediaList(authKey: String, regionId: String, accountId: Int, page: Int): PagedMediaList
}