package com.task.chat.dao.entities.custom

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class ChatLogInfo(
    @Id
    @Column(name = "seq")
    val seq: Int?,

    @Column(name = "chat_room_id")
    val chatRoomId: Int,

    @Column(name = "member_id")
    val memberId: Int,

    @Column(name = "member_login_id")
    val memberLoginId: String,

    @Column(name = "member_name")
    val memberName: String?,

    @Column(name = "member_nickname")
    val memberNickname: String?,

    @Column(name = "message")
    val message: String,

    @Column(name = "send_dt")
    val sendDateTime: LocalDateTime
)