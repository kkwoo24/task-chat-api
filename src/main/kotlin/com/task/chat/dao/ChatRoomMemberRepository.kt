package com.task.chat.dao

import com.task.chat.dao.entities.ChatRoomMember
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Transactional
@Repository
interface ChatRoomMemberRepository: JpaRepository<ChatRoomMember, List<Int>>