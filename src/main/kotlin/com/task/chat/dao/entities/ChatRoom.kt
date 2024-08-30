package com.task.chat.dao.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "chat_room")
data class ChatRoom(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_room_id")
    val chatRoomId: Int?,

    @Column(name = "chat_room_name")
    val chatRoomName: String,

    @Column(name = "creator_id")
    val creatorId: Int,

    @Column(name = "created_dt")
    val createdDateTime: LocalDateTime
)