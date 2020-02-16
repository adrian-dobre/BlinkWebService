package ui.web.blink.infrastructure.repositories.impl

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import ui.web.blink.domain.aggregates.HomeScreen
import ui.web.blink.domain.entities.AccountOptions
import ui.web.blink.domain.entities.Notifications
import ui.web.blink.infrastructure.helpers.RegionalBaseService
import ui.web.blink.infrastructure.helpers.RequestOptions
import ui.web.blink.infrastructure.repositories.AccountRepository

@Component
class AccountRepositoryImpl : AccountRepository {
    @Value("\${blink.serverUrl}")
    lateinit var blinkUrl: String

    override fun getOptions(authKey: String, regionId: String): AccountOptions {
        return RegionalBaseService(regionId, blinkUrl).get(
            RegionalBaseService.requestOptionsAuthKey(authKey, RequestOptions(
                path = "v1/account/options"
            )),
            AccountOptions::class.java
        ).first
    }

    override fun getHomeScreen(authKey: String, regionId: String, accountId: Int): HomeScreen {
        return RegionalBaseService(regionId, blinkUrl).get(
            RegionalBaseService.requestOptionsAuthKey(authKey, RequestOptions(
                path = "v3/accounts/${accountId}/homescreen"
            )),
            HomeScreen::class.java
        ).first
    }

    override fun getNotificationsConfig(authKey: String, regionId: String, accountId: Int): Notifications {
        return RegionalBaseService(regionId, blinkUrl).get(
            RegionalBaseService.requestOptionsAuthKey(authKey, RequestOptions(
                path = "v1/accounts/${accountId}/notifications/configuration"
            )),
            Notifications::class.java
        ).first
    }
}