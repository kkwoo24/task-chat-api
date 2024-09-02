package com.task.chat.api

import com.task.chat.dao.entities.ChatMember
import com.task.chat.dtos.*
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/login")
@Tag(name = "[Login] LoginController", description = "채팅")
class LoginController(
    private val loginService: LoginService
) {

    @ApiResponses(value = [ApiResponse(responseCode = "200", description = "Success")])
    @Operation(summary = "Login Process", description = "Login Process")
    @PostMapping("", produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun login(
        @RequestBody request: LoginRequest
    ): Response<ChatMember> =
        Response(
            payload = loginService.login(request.memberLoginId)
        )
}