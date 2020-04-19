package ui.web.blink.application.controllers

import org.apache.tomcat.util.http.fileupload.IOUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam
import ui.web.blink.infrastructure.repositories.MediaRepository
import javax.servlet.http.HttpServletResponse


@Controller
class MediaController {
    @Autowired
    private lateinit var mediaRepository: MediaRepository

    @GetMapping("/regions/{regionId}/media")
    fun getProgramList(
        @RequestParam mediaPath: String,
        @PathVariable regionId: String,
        @RequestHeader("authToken") authKey: String,
        response: HttpServletResponse

    ) {
        val result = mediaRepository.getMedia(authKey, regionId, mediaPath)
        response.contentType = MediaType.parseMediaType(result.response["Content-Type"].first().toString()).toString()
        response.setContentLengthLong(result.response.contentLength)
        IOUtils.copy(result.response.body().toStream(), response.outputStream);
    }
}