package com.task.chat.dao

import com.task.chat.dao.entities.ChatRoom
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Transactional
@Repository
interface ChatRoomRepository: JpaRepository<ChatRoom, Int>