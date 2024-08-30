package com.task.chat.api

import com.task.chat.dao.ChatMemberRepository
import com.task.chat.dao.ChatRoomMemberRepository
import com.task.chat.dao.ChatRoomRepository
import com.task.chat.dao.entities.ChatMember
import com.task.chat.dao.entities.ChatRoom
import com.task.chat.dao.entities.ChatRoomMember
import com.task.chat.dtos.ControlResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class ChatService(
    private val chatRoomRepository: ChatRoomRepository,
    private val chatRoomMemberRepository: ChatRoomMemberRepository,
    private val chatMemberRepository: ChatMemberRepository,
) {

    @Transactional
    fun createMember(memberLoginId: String, memberName: String, memberNickname: String): ControlResponse {

        /*맴버 추가*/
        chatMemberRepository.save(
            ChatMember(
                chatMemberId = null,
                memberLoginId = memberLoginId,
                memberName = memberName,
                memberNickname = memberNickname,
                createdDateTime = LocalDateTime.now()
            )
        )
        return ControlResponse(true, "맴버 추가 성공")
    }

    @Transactional
    fun createChatRoom(chatRoomName: String, creatorId: Int, memberIds: List<Int>): ControlResponse {

        /*채팅방 생성*/
        val chatRoomId = chatRoomRepository.save(ChatRoom(
            chatRoomId = null,
            chatRoomName = chatRoomName,
            creatorId = creatorId,
            createdDateTime = LocalDateTime.now()
        ))

        /*채팅방 맴버 추가*/
        if(memberIds.isNotEmpty()) {
            memberIds.forEach {
                chatRoomMemberRepository.save(ChatRoomMember(
                    seq = null,
                    chatRoomId = chatRoomId.chatRoomId!!,
                    memberId = it,
                    joinDateTome = LocalDateTime.now()
                ))
            }
        }

        return ControlResponse(true, "채팅방 생성 성공")
    }

    /*TODO::채팅방 나가기 구현*/
//    @Transactional
//    fun leaveChatRoom(chatRoomId: Int, memberId: Int) : ControlResponse {
//        chatRoomMemberRepository.deleteChatRoomMemberByChatRoomIdAndMemberId(chatRoomId, memberId)
//        return ControlResponse(true, "채팅방 나가기 성공")
//    }



}