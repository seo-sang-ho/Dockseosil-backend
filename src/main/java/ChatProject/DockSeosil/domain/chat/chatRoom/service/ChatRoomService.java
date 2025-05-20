package ChatProject.DockSeosil.domain.chat.chatRoom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import ChatProject.DockSeosil.domain.chat.chatRoom.entity.ChatRoom;
import ChatProject.DockSeosil.domain.chat.chatRoom.repository.ChatRoomRepository;
import ChatProject.DockSeosil.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

	private final ChatRoomRepository chatRoomRepository;

	public void make(String name) {

		ChatRoom chatRoom = ChatRoom.builder()
			.name(name)
			.build();

		chatRoomRepository.save(chatRoom);
	}

	public List<ChatRoom> findAll() {
		return chatRoomRepository.findAll();
	}

	public ChatRoom findById(Long roomId) {
		return chatRoomRepository.findById(roomId)
			.orElseThrow(() -> new NotFoundException("채팅방이 존재하지 않습니다."));
	}
}
