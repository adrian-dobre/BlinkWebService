/*
 * Copyright (c) 2020 Adrian Dobre - GPL v3 License.
 *
 * This file is subject to the terms and conditions defined in
 * the 'LICENSE.txt' file, which is part of this source code package.
 */

package ui.web.blink.infrastructure.helpers

class RegionalMediaServiceClient(regionId: String, blinkUrl: String, commonHeaders: CommonHeaders) :
    BaseService("https://rest-${regionId}.${blinkUrl}", commonHeaders, BodyMapper.NONE, BodyMapper.NONE) {
    companion object {
        fun requestOptionsAuthKey(authKey: String, requestOptions: RequestOptions = RequestOptions()): RequestOptions {
            requestOptions.headers["token-auth"] = authKey
            return requestOptions
        }
    }
}