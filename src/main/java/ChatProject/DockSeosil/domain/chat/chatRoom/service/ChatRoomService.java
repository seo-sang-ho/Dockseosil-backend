package ChatProject.DockSeosil.domain.chat.chatRoom.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ChatProject.DockSeosil.domain.chat.chatRoom.entity.ChatRoom;
import ChatProject.DockSeosil.domain.chat.chatRoom.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

	private final ChatRoomRepository chatRoomRepository;

	public void make(String name) {

		ChatRoom chatRoom = new ChatRoom(name);

		chatRoomRepository.save(chatRoom);
	}

	public List<ChatRoom> findAll() {
		return chatRoomRepository.findAll();
	}
}
