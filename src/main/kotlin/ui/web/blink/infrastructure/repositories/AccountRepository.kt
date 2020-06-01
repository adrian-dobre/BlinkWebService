/*
 * Copyright (c) 2020 Adrian Dobre - GPL v3 License.
 *
 * This file is subject to the terms and conditions defined in
 * the 'LICENSE.txt' file, which is part of this source code package.
 */

package ui.web.blink.infrastructure.repositories

import ui.web.blink.domain.aggregates.HomeScreen
import ui.web.blink.domain.aggregates.PagedMediaList
import ui.web.blink.domain.entities.Account
import ui.web.blink.domain.entities.AccountOptions
import ui.web.blink.domain.entities.MotionRegions
import ui.web.blink.domain.entities.Notifications

interface AccountRepository {
    fun getOptions(authKey: String, regionId: String): AccountOptions
    fun getHomeScreen(authKey: String, regionId: String, accountId: Int): HomeScreen
    fun getNotificationsConfig(authKey: String, regionId: String, accountId: Int): Notifications
    fun getMediaList(authKey: String, regionId: String, accountId: Int, page: Int): PagedMediaList
    fun getAccount(authKey: String, regionId: String): Account
    fun getAccountNetworkCameraMotionRegions(authKey: String, regionId: String, accountId: Int, networkId: Int, cameraId: Int): MotionRegions
}