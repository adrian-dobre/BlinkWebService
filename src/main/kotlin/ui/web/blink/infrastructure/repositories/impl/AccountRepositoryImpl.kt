package ui.web.blink.infrastructure.repositories.impl

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import ui.web.blink.domain.aggregates.HomeScreen
import ui.web.blink.domain.aggregates.PagedMediaList
import ui.web.blink.domain.entities.Account
import ui.web.blink.domain.entities.AccountOptions
import ui.web.blink.domain.entities.MotionRegions
import ui.web.blink.domain.entities.Notifications
import ui.web.blink.infrastructure.helpers.RegionalBaseService
import ui.web.blink.infrastructure.helpers.RequestOptions
import ui.web.blink.infrastructure.helpers.RequestParams
import ui.web.blink.infrastructure.repositories.AccountRepository

@Component
class AccountRepositoryImpl : AccountRepository {
    @Value("\${blink.serverUrl}")
    lateinit var blinkUrl: String

    override fun getOptions(authKey: String, regionId: String): AccountOptions {
        return RegionalBaseService(regionId, blinkUrl).get(
            RegionalBaseService.requestOptionsAuthKey(
                authKey, RequestOptions(
                    path = "api/v1/account/options"
                )
            ),
            AccountOptions::class.java
        ).first
    }

    override fun getHomeScreen(authKey: String, regionId: String, accountId: Int): HomeScreen {
        return RegionalBaseService(regionId, blinkUrl).get(
            RegionalBaseService.requestOptionsAuthKey(
                authKey, RequestOptions(
                    path = "api/v3/accounts/${accountId}/homescreen"
                )
            ),
            HomeScreen::class.java
        ).first
    }

    override fun getNotificationsConfig(authKey: String, regionId: String, accountId: Int): Notifications {
        return RegionalBaseService(regionId, blinkUrl).get(
            RegionalBaseService.requestOptionsAuthKey(
                authKey, RequestOptions(
                    path = "api/v1/accounts/${accountId}/notifications/configuration"
                )
            ),
            Notifications::class.java
        ).first
    }

    override fun getMediaList(authKey: String, regionId: String, accountId: Int, page: Int): PagedMediaList {
        return RegionalBaseService(regionId, blinkUrl).get(
            RegionalBaseService.requestOptionsAuthKey(
                authKey, RequestOptions(
                    params = RequestParams(
                        query = listOf(
                            Pair("page", page.toString()),
                            Pair("since", "1970-01-01T00:00:00 0000")
                        )
                    ),
                    path = "api/v1/accounts/${accountId}/media/changed"
                )
            ),
            PagedMediaList::class.java
        ).first
    }

    override fun getAccount(authKey: String, regionId: String): Account {
        return RegionalBaseService(regionId, blinkUrl).get(
            RegionalBaseService.requestOptionsAuthKey(
                authKey, RequestOptions(
                    path = "user"
                )
            ),
            Account::class.java
        ).first
    }

    override fun getAccountNetworkCameraMotionRegions(authKey: String, regionId: String, accountId: Int, networkId: Int, cameraId: Int): MotionRegions {
        return RegionalBaseService(regionId, blinkUrl).get(
            RegionalBaseService.requestOptionsAuthKey(
                authKey, RequestOptions(
                    path = "api/v1/accounts/${accountId}/networks/${networkId}/cameras/${cameraId}/motion_regions"
                )
            ),
            MotionRegions::class.java
        ).first
    }
}