/*
 * Copyright (c) 2020 Adrian Dobre - GPL v3 License.
 *
 * This file is subject to the terms and conditions defined in
 * the 'LICENSE.txt' file, which is part of this source code package.
 */

package ui.web.blink.application.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ui.web.blink.domain.aggregates.HomeScreen
import ui.web.blink.domain.aggregates.PagedMediaList
import ui.web.blink.domain.entities.*
import ui.web.blink.infrastructure.repositories.AccountRepository


@CrossOrigin
@RestController
class AccountController {
    @Autowired
    private lateinit var accountRepository: AccountRepository

    @GetMapping("/regions/{regionId}/account/options")
    fun getAccountOptions(
        @PathVariable regionId: String,
        @RequestHeader("authToken") authKey: String
    ): AccountOptions {
        return accountRepository.getOptions(authKey, regionId)
    }

    @GetMapping("/regions/{regionId}/accounts/{accountId}/home-screen")
    fun getAccountHomeScreen(
        @PathVariable accountId: Int,
        @PathVariable regionId: String,
        @RequestHeader("authToken") authKey: String
    ): HomeScreen {
        return accountRepository.getHomeScreen(authKey, regionId, accountId)
    }

    @GetMapping("/regions/{regionId}/accounts/{accountId}/notifications/configuration")
    fun getAccountNotificationsConfig(
        @PathVariable accountId: Int,
        @PathVariable regionId: String,
        @RequestHeader("authToken") authKey: String
    ): Notifications {
        return accountRepository.getNotificationsConfig(authKey, regionId, accountId)
    }

    @GetMapping("/regions/{regionId}/accounts/{accountId}/media")
    fun getAccountMediaList(
        @PathVariable accountId: Int,
        @PathVariable regionId: String,
        @RequestParam(required = false) page: Int?,
        @RequestHeader("authToken") authKey: String
    ): PagedMediaList {
        return accountRepository.getMediaList(authKey, regionId, accountId, page ?: 1)
    }

    @GetMapping("/regions/{regionId}/user")
    fun getAccount(
        @PathVariable regionId: String,
        @RequestHeader("authToken") authKey: String
    ): Account {
        return accountRepository.getAccount(authKey, regionId)
    }

    @GetMapping("/regions/{regionId}/accounts/{accountId}/networks/{networkId}/cameras/{cameraId}/motion-regions")
    fun getAccountNetworkCameraMotionRegions(
        @PathVariable regionId: String,
        @PathVariable accountId: Int,
        @PathVariable networkId: Int,
        @PathVariable cameraId: Int,
        @RequestHeader("authToken") authKey: String
    ): MotionRegions {
        return accountRepository.getAccountNetworkCameraMotionRegions(authKey, regionId, accountId, networkId, cameraId)
    }

    @PostMapping("/regions/{regionId}/accounts/{accountId}/networks/{networkId}/state/arm")
    fun armNetwork(
        @PathVariable regionId: String,
        @PathVariable accountId: Int,
        @PathVariable networkId: Int,
        @RequestHeader("authToken") authKey: String
    ): CommandStatus {
        return accountRepository.armNetwork(authKey, regionId, accountId, networkId)
    }

    @PostMapping("/regions/{regionId}/accounts/{accountId}/networks/{networkId}/state/disarm")
    fun disarmNetwork(
        @PathVariable regionId: String,
        @PathVariable accountId: Int,
        @PathVariable networkId: Int,
        @RequestHeader("authToken") authKey: String
    ): CommandStatus {
        return accountRepository.disarmNetwork(authKey, regionId, accountId, networkId)
    }
}