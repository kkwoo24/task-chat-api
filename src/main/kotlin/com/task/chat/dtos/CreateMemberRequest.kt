package com.task.chat.dtos

import com.fasterxml.jackson.annotation.JsonProperty

data class CreateMemberRequest(

    @JsonProperty("memberLoginId")
    val memberLoginId: String,

    @JsonProperty("memberName")
    val memberName: String,

    @JsonProperty("memberNickname")
    val memberNickname: String
)