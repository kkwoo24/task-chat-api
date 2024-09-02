package com.task.chat.libs

import org.springframework.stereotype.Component
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.CloseStatus
import java.util.concurrent.ConcurrentHashMap

@Component
class ChatWebSocketHandler : TextWebSocketHandler() {

    private val sessions = ConcurrentHashMap.newKeySet<WebSocketSession>()

    override fun afterConnectionEstablished(session: WebSocketSession) {
        sessions.add(session)
        broadcastConnectionStatus()
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        sessions.remove(session)
        broadcastConnectionStatus()
    }

    fun broadcastConnectionStatus() {
        val message = "Current connections: ${sessions.size}"
        sessions.forEach { it.sendMessage(TextMessage(message)) }
    }
}