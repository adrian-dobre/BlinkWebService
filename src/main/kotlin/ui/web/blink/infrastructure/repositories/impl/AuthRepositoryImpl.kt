package ui.web.blink.infrastructure.repositories.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import ui.web.blink.domain.entities.Session
import ui.web.blink.infrastructure.helpers.BaseService
import ui.web.blink.infrastructure.helpers.RequestOptions
import ui.web.blink.infrastructure.helpers.RequestParams
import ui.web.blink.infrastructure.repositories.AuthRepository
import org.springframework.stereotype.Component
import ui.web.blink.domain.entities.Login
import javax.annotation.PostConstruct

@Component
class AuthRepositoryImpl : AuthRepository {
    @Value("\${blink.serverUrl}")
    lateinit var blinkUrl: String
    private lateinit var baseService: BaseService;

    @PostConstruct
    fun init() {
        baseService = BaseService("https://rest-prod.${blinkUrl}/api");
    }


    override fun login(login: Login): Session {
        return baseService.post(
            RequestOptions(
                path = "v2/login",
                params = RequestParams(
                    body = login
                )
            ),
            Session::class.java
        ).first
    }

    override fun logout() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}