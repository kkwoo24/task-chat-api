package com.task.chat.dtos

import com.fasterxml.jackson.annotation.JsonProperty

data class LoginRequest(

    @JsonProperty("memberLoginId")
    val memberLoginId: String

)