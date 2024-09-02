package com.task.chat.dao

import com.task.chat.dao.entities.ChatRoom
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Transactional
@Repository
interface ChatRoomRepository: JpaRepository<ChatRoom, Int> {

    @Query(value = """
        SELECT
            new com.task.chat.dao.entities.ChatRoom(
                cr.chatRoomId,
                cr.chatRoomName,
                cr.creatorId,
                cr.createdDateTime
            )
        FROM
            ChatRoom cr
        INNER JOIN ChatRoomMember crm
            ON cr.chatRoomId = crm.chatRoomId
        WHERE
            crm.memberId = :memberId
    """)
    fun findChatRoomsByMemberId(
        memberId: Int
    ): List<ChatRoom>

}