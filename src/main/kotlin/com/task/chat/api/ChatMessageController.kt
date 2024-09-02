package com.task.chat.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/messages")
class ChatMessageController(private val chatMessageConsumer: ChatMessageConsumer) {

    @GetMapping
    fun getMessages(): List<String> {
        return chatMessageConsumer.getMessages()
    }
}