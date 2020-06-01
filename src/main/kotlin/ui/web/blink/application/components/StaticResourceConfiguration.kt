/*
 * Copyright (c) 2020 Adrian Dobre - GPL v3 License.
 *
 * This file is subject to the terms and conditions defined in
 * the 'LICENSE.txt' file, which is part of this source code package.
 */

package ui.web.blink.application.components

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.Resource
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.resource.PathResourceResolver


@Configuration
open class StaticResourceConfiguration : WebMvcConfigurer {
    @Value("\${uiBuildPath}")
    lateinit var uiBuildPath: String
    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry
            .addResourceHandler("/**")
            .addResourceLocations("file:///${uiBuildPath}/")
            .resourceChain(true)
            .addResolver(object : PathResourceResolver() {
                override fun getResource(resourcePath: String, location: Resource): Resource? {
                    val requestedResource = location.createRelative(resourcePath)
                    return if (requestedResource.isReadable) {
                        super.getResource(resourcePath, location)
                    } else {
                        location.createRelative("index.html")
                    }
                }
            })
    }
}
