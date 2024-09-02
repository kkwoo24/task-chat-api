package com.task.chat.dao

import com.task.chat.dao.entities.ChatMember
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Transactional
@Repository
interface ChatMemberRepository: JpaRepository<ChatMember, Int> {
    fun findByMemberLoginId(memberLoginId: String): ChatMember?
}