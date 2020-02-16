package ui.web.blink.infrastructure.helpers

class RegionalMediaService(regionId: String, blinkUrl: String) : MediaService("https://rest-${regionId}.${blinkUrl}") {
    companion object {
        fun requestOptionsAuthKey(authKey: String, requestOptions: RequestOptions = RequestOptions()): RequestOptions {
            requestOptions.headers["token-auth"] = authKey
            return requestOptions
        }
    }
}