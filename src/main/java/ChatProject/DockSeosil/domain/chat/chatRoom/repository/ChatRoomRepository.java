package ChatProject.DockSeosil.domain.chat.chatRoom.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ChatProject.DockSeosil.domain.chat.chatRoom.entity.ChatRoom;

@Repository
public class ChatRoomRepository {

	private Long lastChatRoomId = 0L;
	private List<ChatRoom> chatRooms = new ArrayList<>();

	public ChatRoom save(ChatRoom chatRoom) {
		chatRoom.setId(++lastChatRoomId);
		chatRooms.add(chatRoom);

		return chatRoom;
	}

	public List<ChatRoom> findAll() {
		return chatRooms;
	}
}
