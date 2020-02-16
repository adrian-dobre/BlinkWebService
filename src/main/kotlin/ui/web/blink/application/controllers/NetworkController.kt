package ui.web.blink.application.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ui.web.blink.domain.entities.Program
import ui.web.blink.infrastructure.repositories.NetworkRepository

@RestController
class NetworkController {
    @Autowired
    private lateinit var networkRepository: NetworkRepository


    @GetMapping("/regions/{regionId}/networks/{networkId}/programs")
    fun getProgramList(
        @PathVariable regionId: String,
        @PathVariable networkId: Int,
        @RequestHeader("authToken") authKey: String
    ): List<Program> {
        return networkRepository.getProgramList(authKey, regionId, networkId)
    }
}