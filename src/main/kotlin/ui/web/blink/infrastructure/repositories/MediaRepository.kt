/*
 * Copyright (c) 2020 Adrian Dobre - GPL v3 License.
 *
 * This file is subject to the terms and conditions defined in
 * the 'LICENSE.txt' file, which is part of this source code package.
 */

package ui.web.blink.infrastructure.repositories

import ui.web.blink.infrastructure.helpers.BaseServiceResult

interface MediaRepository {
    fun getMedia(authKey: String, regionId: String, mediaPath: String): BaseServiceResult<String>
}