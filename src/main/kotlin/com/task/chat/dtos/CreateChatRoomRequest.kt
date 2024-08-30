package com.task.chat.dtos

import com.fasterxml.jackson.annotation.JsonProperty

data class CreateChatRoomRequest(

    @JsonProperty("chatRoomName")
    val chatRoomName: String,

    @JsonProperty("creatorId")
    val creatorId: Int,

    @JsonProperty("memberIds")
    val memberIds: List<Int>

)