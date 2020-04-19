package ui.web.blink.infrastructure.helpers

class RegionalBaseServiceClient(regionId: String, blinkUrl: String) : BaseService("https://rest-${regionId}.${blinkUrl}") {
    companion object {
        fun requestOptionsAuthKey(authKey: String, requestOptions: RequestOptions = RequestOptions()): RequestOptions {
            requestOptions.headers["token-auth"] = authKey
            return requestOptions
        }
    }
}