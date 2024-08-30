package com.task.chat.api

import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class BaseController {

    @GetMapping("/swagger")
    fun swagger(
        response: HttpServletResponse
    ) {
        response.sendRedirect("/swagger-ui.html")
    }

    @GetMapping("/swagger-ui")
    fun swaggerUi(
        response: HttpServletResponse
    ) {
        response.sendRedirect("/swagger-ui.html")
    }

}