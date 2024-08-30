package com.task.chat.api

import com.task.chat.dtos.ControlResponse
import com.task.chat.dtos.CreateChatRoomRequest
import com.task.chat.dtos.Response
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/chat")
@Tag(name = "[Chat] ChatController", description = "채팅")
class ChatController(
    private val chatService: ChatService
) {

    @ApiResponses(value = [ApiResponse(responseCode = "200", description = "Success")])
    @Operation(summary = "Create Chat Room", description = "Create Chat Room")
    @PostMapping("/create", produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createChatRoom(
        @RequestBody request: CreateChatRoomRequest
    ): Response<ControlResponse> =
        Response(
            payload = chatService.createChatRoom(request.chatRoomName, request.creatorId, request.memberIds)
        )

}