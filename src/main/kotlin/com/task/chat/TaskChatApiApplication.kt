package com.task.chat

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TaskChatApiApplication

fun main(args: Array<String>) {
    runApplication<TaskChatApiApplication>(*args)
}
