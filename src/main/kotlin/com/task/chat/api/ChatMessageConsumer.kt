package com.task.chat.api

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class ChatMessageConsumer {

    private val messages = mutableListOf<String>()

    @KafkaListener(topics = ["chat-room-1"], groupId = "chat-group")
    fun listen(message: String) {
        messages.add(message)
    }

    fun getMessages(): List<String> {
        return messages
    }
}