package com.task.chat.api

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class ChatMessageProducer(private val kafkaTemplate: KafkaTemplate<String, String>) {

    fun sendMessage(topic: String, message: String) {
        kafkaTemplate.send(topic, message)
    }
}