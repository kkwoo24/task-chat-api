package com.task.chat.api

import com.task.chat.dtos.ControlResponse
import com.task.chat.dtos.CreateMemberRequest
import com.task.chat.dtos.Response
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/member")
@Tag(name = "[Member] MemberController", description = "채팅")
class MemberController(
    private val chatService: ChatService
) {

    @ApiResponses(value = [ApiResponse(responseCode = "200", description = "Success")])
    @Operation(summary = "Create Member", description = "Create Member")
    @PostMapping("/create", produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createChatRoom(
        @RequestBody request: CreateMemberRequest
    ): Response<ControlResponse> =
        Response(
            payload = chatService.createMember(request.memberLoginId, request.memberName, request.memberNickname)
        )

}