package com.task.chat.api

import com.task.chat.dao.ChatMemberRepository
import com.task.chat.dao.entities.ChatMember
import com.task.chat.libs.ChatWebSocketHandler
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class LoginService(
    private val chatMemberRepository: ChatMemberRepository,
    private val chatWebSocketHandler: ChatWebSocketHandler
    ) {

    @Transactional
    fun login(memberLoginId: String): ChatMember {
        return chatMemberRepository.findByMemberLoginId(memberLoginId) ?: run {
            val newMember = chatMemberRepository.save(
                ChatMember(
                    chatMemberId = null,
                    memberLoginId = memberLoginId,
                    memberName = null,
                    memberNickname = null,
                    createdDateTime = LocalDateTime.now()
                )
            )

            chatWebSocketHandler.broadcastConnectionStatus()

            newMember
        }
    }

}