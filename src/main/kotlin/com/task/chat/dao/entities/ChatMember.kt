package com.task.chat.dao.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "chat_member")
data class ChatMember(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_member_id")
    val chatMemberId: Int?,

    @Column(name = "member_login_id")
    val memberLoginId: String,

    @Column(name = "member_name")
    val memberName: String,

    @Column(name = "member_nickname")
    val memberNickname: String,

    @Column(name = "created_dt")
    val createdDateTime: LocalDateTime
)