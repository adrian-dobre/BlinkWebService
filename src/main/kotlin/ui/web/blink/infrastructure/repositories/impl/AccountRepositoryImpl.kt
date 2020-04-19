package ui.web.blink.infrastructure.repositories.impl

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import ui.web.blink.domain.aggregates.HomeScreen
import ui.web.blink.domain.aggregates.PagedMediaList
import ui.web.blink.domain.entities.Account
import ui.web.blink.domain.entities.AccountOptions
import ui.web.blink.domain.entities.MotionRegions
import ui.web.blink.domain.entities.Notifications
import ui.web.blink.infrastructure.helpers.RegionalBaseServiceClient
import ui.web.blink.infrastructure.helpers.RequestOptions
import ui.web.blink.infrastructure.helpers.RequestParams
import ui.web.blink.infrastructure.repositories.AccountRepository

@Component
class AccountRepositoryImpl : AccountRepository {
    @Value("\${blink.serverUrl}")
    lateinit var blinkUrl: String

    override fun getOptions(authKey: String, regionId: String): AccountOptions {
        return RegionalBaseServiceClient(regionId, blinkUrl).get(
            RegionalBaseServiceClient.requestOptionsAuthKey(
                authKey, RequestOptions(
                    path = "api/v1/account/options"
                )
            ),
            AccountOptions::class.java
        ).body
    }

    override fun getHomeScreen(authKey: String, regionId: String, accountId: Int): HomeScreen {
        return RegionalBaseServiceClient(regionId, blinkUrl).get(
            RegionalBaseServiceClient.requestOptionsAuthKey(
                authKey, RequestOptions(
                    path = "api/v3/accounts/${accountId}/homescreen"
                )
            ),
            HomeScreen::class.java
        ).body
    }

    override fun getNotificationsConfig(authKey: String, regionId: String, accountId: Int): Notifications {
        return RegionalBaseServiceClient(regionId, blinkUrl).get(
            RegionalBaseServiceClient.requestOptionsAuthKey(
                authKey, RequestOptions(
                    path = "api/v1/accounts/${accountId}/notifications/configuration"
                )
            ),
            Notifications::class.java
        ).body
    }

    override fun getMediaList(authKey: String, regionId: String, accountId: Int, page: Int): PagedMediaList {
        return RegionalBaseServiceClient(regionId, blinkUrl).get(
            RegionalBaseServiceClient.requestOptionsAuthKey(
                authKey, RequestOptions(
                    params = RequestParams(
                        query = mutableMapOf(
                            Pair("page", page.toString()),
                            Pair("since", "1970-01-01T00:00:00 0000")
                        )
                    ),
                    path = "api/v1/accounts/${accountId}/media/changed"
                )
            ),
            PagedMediaList::class.java
        ).body
    }

    override fun getAccount(authKey: String, regionId: String): Account {
        return RegionalBaseServiceClient(regionId, blinkUrl).get(
            RegionalBaseServiceClient.requestOptionsAuthKey(
                authKey, RequestOptions(
                    path = "user"
                )
            ),
            Account::class.java
        ).body
    }

    override fun getAccountNetworkCameraMotionRegions(authKey: String, regionId: String, accountId: Int, networkId: Int, cameraId: Int): MotionRegions {
        return RegionalBaseServiceClient(regionId, blinkUrl).get(
            RegionalBaseServiceClient.requestOptionsAuthKey(
                authKey, RequestOptions(
                    path = "api/v1/accounts/${accountId}/networks/${networkId}/cameras/${cameraId}/motion_regions"
                )
            ),
            MotionRegions::class.java
        ).body
    }
}