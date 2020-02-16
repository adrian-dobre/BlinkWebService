package ui.web.blink.infrastructure.repositories.impl

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import ui.web.blink.domain.entities.Program
import ui.web.blink.infrastructure.helpers.RegionalBaseService
import ui.web.blink.infrastructure.helpers.RequestOptions
import ui.web.blink.infrastructure.repositories.NetworkRepository

@Component
class NetworkRepositoryImpl : NetworkRepository {
    @Value("\${blink.serverUrl}")
    lateinit var blinkUrl: String

    override fun getProgramList(authKey: String, regionId: String, networkId: Int): List<Program> {

        val regionalBaseService = RegionalBaseService(regionId, blinkUrl)
        return regionalBaseService.get(
            RegionalBaseService.requestOptionsAuthKey(
                authKey, RequestOptions(
                    path = "v1/networks/${networkId}/programs"
                )
            ),
            regionalBaseService.getTypeReference<List<Program>>()
        ).first
    }
}