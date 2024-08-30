package com.task.chat.dao.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "chat_log")
data class ChatLog(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
    val seq: Int?,

    @Column(name = "chat_room_id")
    val chatRoomId: Int,

    @Column(name = "member_id")
    val memberId: Int,

    @Column(name = "send_dt")
    val sendDateTime: LocalDateTime
)