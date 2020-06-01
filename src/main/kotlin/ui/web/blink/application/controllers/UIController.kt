/*
 * Copyright (c) 2020 Adrian Dobre - GPL v3 License.
 *
 * This file is subject to the terms and conditions defined in
 * the 'LICENSE.txt' file, which is part of this source code package.
 */

package ui.web.blink.application.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping

@CrossOrigin(origins = ["*"])
@Controller
class UIController {

    @GetMapping("/")
    fun home(): String? {
        return "forward:/index.html"
    }
}