package com.task.chat.dtos

import com.fasterxml.jackson.annotation.JsonProperty

data class GetChatRoomsRequest(

    @JsonProperty("memberId")
    val memberId: Int

)