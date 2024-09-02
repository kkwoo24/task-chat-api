package com.task.chat.api

import com.task.chat.dao.entities.ChatRoom
import com.task.chat.dao.entities.custom.ChatLogInfo
import com.task.chat.dtos.*
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
    @Operation(summary = "Get Chat Room List", description = "Get Chat Room List")
    @PostMapping("/rooms", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getChatRooms(
        @RequestBody request: GetChatRoomsRequest
    ): Response<List<ChatRoom>> =
        Response(
            payload = chatService.findChatRooms(request.memberId)
        )

    @ApiResponses(value = [ApiResponse(responseCode = "200", description = "Success")])
    @Operation(summary = "Get Chat Log", description = "Get Chat Log")
    @PostMapping("/logs", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getChatLogs(
        @RequestBody request: GetChatLogsRequest
    ): Response<List<ChatLogInfo>> =
        Response(
            payload = chatService.findChatLogs(request.chatRoomId)
        )

    @ApiResponses(value = [ApiResponse(responseCode = "200", description = "Success")])
    @Operation(summary = "Create Chat Room", description = "Create Chat Room")
    @PostMapping("/create", produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createChatRoom(
        @RequestBody request: CreateChatRoomRequest
    ): Response<ControlResponse> =
        Response(
            payload = chatService.createChatRoom(request.chatRoomName, request.creatorId, request.memberIds)
        )

    @ApiResponses(value = [ApiResponse(responseCode = "200", description = "Success")])
    @Operation(summary = "Send Chat Message", description = "Send Chat Message")
    @PostMapping("/message/send", produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun sendMessage(
        @RequestBody request: SendChatMessageRequest
    ): Response<ControlResponse> =
        Response(
            payload = chatService.sendMessage(request.chatRoomId, request.memberId, request.message)
        )

    @Operation(summary = "Connect Web Socket", description = "Connect Web Socket")
    @GetMapping("/ws")
    fun getWebSocketEndpoint(): String {
        return "ws://localhost:8080/ws/chat"
    }

}