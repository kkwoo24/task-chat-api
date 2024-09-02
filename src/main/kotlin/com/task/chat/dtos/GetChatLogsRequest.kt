package com.task.chat.dtos

import com.fasterxml.jackson.annotation.JsonProperty

data class GetChatLogsRequest(

    @JsonProperty("chatRoomId")
    val chatRoomId: Int

)