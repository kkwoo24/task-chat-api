package com.task.chat.dtos

import com.fasterxml.jackson.annotation.JsonProperty

data class ControlResponse (
    @JsonProperty("isSuccess")
    val isSuccess: Boolean = false,

    @JsonProperty("message")
    val message: String
)