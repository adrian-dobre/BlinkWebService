package ui.web.blink.infrastructure.helpers

class RegionalBaseService(regionId: String, blinkUrl: String) : BaseService("https://rest-${regionId}.${blinkUrl}/api") {
    companion object {
        fun requestOptionsAuthKey(authKey: String, requestOptions: RequestOptions = RequestOptions()): RequestOptions {
            requestOptions.headers["token-auth"] = authKey
            return requestOptions
        }
    }
}