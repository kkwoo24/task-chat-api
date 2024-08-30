package com.task.chat.dao.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "chat_room_member")
data class ChatRoomMember(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val seq: Int?,

    @Column(name = "chat_room_id")
    val chatRoomId: Int?,

    @Column(name = "member_id")
    val memberId: Int,

    @Column(name = "join_dt")
    val joinDateTome: LocalDateTime

)