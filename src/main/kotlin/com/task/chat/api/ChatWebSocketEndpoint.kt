package com.task.chat.api

import jakarta.websocket.OnClose
import jakarta.websocket.OnMessage
import jakarta.websocket.OnOpen
import jakarta.websocket.Session
import jakarta.websocket.server.ServerEndpoint

@ServerEndpoint("/ws/chat")
class ChatWebSocketEndpoint {

    @OnOpen
    fun onOpen(session: Session) {
        println("Session opened: ${session.id}")
    }

    @OnMessage
    fun onMessage(message: String, session: Session) {
        println("Message received: $message")
        session.basicRemote.sendText("Echo: $message")
    }

    @OnClose
    fun onClose(session: Session) {
        println("Session closed: ${session.id}")
    }
}