package com.task.chat.api

import com.task.chat.dao.ChatLogRepository
import com.task.chat.dao.ChatMemberRepository
import com.task.chat.dao.ChatRoomMemberRepository
import com.task.chat.dao.ChatRoomRepository
import com.task.chat.dao.entities.ChatLog
import com.task.chat.dao.entities.ChatMember
import com.task.chat.dao.entities.ChatRoom
import com.task.chat.dao.entities.ChatRoomMember
import com.task.chat.dao.entities.custom.ChatLogInfo
import com.task.chat.dtos.ControlResponse
import com.task.chat.libs.ChatCrypt
import com.task.chat.libs.ChatWebSocketHandler
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class ChatService(
    private val chatRoomRepository: ChatRoomRepository,
    private val chatRoomMemberRepository: ChatRoomMemberRepository,
    private val chatMemberRepository: ChatMemberRepository,
    private val chatLogRepository: ChatLogRepository,
    private val chatMessageProducer: ChatMessageProducer,
    private val chatWebSocketHandler: ChatWebSocketHandler
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

        chatWebSocketHandler.broadcastConnectionStatus()

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

    @Transactional
    fun findChatRooms(memberId: Int): List<ChatRoom> {
        /*맴버가 속한 채팅방 리스트 조회*/
        return chatRoomRepository.findChatRoomsByMemberId(memberId)
    }

    @Transactional
    fun findChatLogs(chatRoomId: Int): List<ChatLogInfo> {
        /*맴버가 속한 채팅방 리스트 조회*/
        val chatLogs = chatLogRepository.findChatLogsByChatRoomId(chatRoomId)
        return chatLogs.map { chatLogInfo ->
            chatLogInfo.copy(message = ChatCrypt.decrypt(chatLogInfo.message))
        }
    }

    @Transactional
    fun sendMessage(chatRoomId: Int, memberId: Int, message: String): ControlResponse {

        val encryptedMessage = ChatCrypt.encrypt(message)

        /*채팅메시지 로그 남기기*/
        chatLogRepository.save(ChatLog(
            seq = null,
            chatRoomId = chatRoomId,
            memberId = memberId,
            message = encryptedMessage,
            sendDateTime = LocalDateTime.now()
        ))

        /*메시지 브로커로 전송(kafka 연동)*/
        chatMessageProducer.sendMessage("chat-room-${chatRoomId}", encryptedMessage)

        return ControlResponse(true, "채팅 메시지 전송 성공")
    }

    /*TODO::채팅방 나가기 구현*/
//    @Transactional
//    fun leaveChatRoom(chatRoomId: Int, memberId: Int) : ControlResponse {
//        chatRoomMemberRepository.deleteChatRoomMemberByChatRoomIdAndMemberId(chatRoomId, memberId)
//        return ControlResponse(true, "채팅방 나가기 성공")
//    }



}