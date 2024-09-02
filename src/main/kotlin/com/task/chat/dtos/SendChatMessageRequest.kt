package com.task.chat.dtos

import com.fasterxml.jackson.annotation.JsonProperty

data class SendChatMessageRequest(

    @JsonProperty("chatRoomId")
    val chatRoomId: Int,

    @JsonProperty("memberId")
    val memberId: Int,

    @JsonProperty("message")
    val message: String

)