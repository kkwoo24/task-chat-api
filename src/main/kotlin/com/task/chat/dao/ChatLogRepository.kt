package com.task.chat.dao

import com.task.chat.dao.entities.ChatLog
import com.task.chat.dao.entities.custom.ChatLogInfo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Transactional
@Repository
interface ChatLogRepository: JpaRepository<ChatLog, Int> {
    @Query(value = """
        SELECT
            new com.task.chat.dao.entities.custom.ChatLogInfo(
                cl.seq,
                cl.chatRoomId,
                cl.memberId,
                cm.memberLoginId,
                cm.memberName,
                cm.memberNickname,
                cl.message,
                cl.sendDateTime
            )
        FROM
            ChatLog cl
        INNER JOIN ChatMember cm
            ON cl.memberId = cm.chatMemberId
        WHERE
            cl.chatRoomId = :chatRoomId
        ORDER BY
            cl.sendDateTime ASC
    """)
    fun findChatLogsByChatRoomId(
        chatRoomId: Int
    ): List<ChatLogInfo>
}