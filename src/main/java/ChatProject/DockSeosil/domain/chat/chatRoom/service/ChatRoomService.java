package ChatProject.DockSeosil.domain.chat.chatRoom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ChatProject.DockSeosil.domain.chat.chatRoom.dto.ChatRoomResponseDTO;
import ChatProject.DockSeosil.domain.chat.chatRoom.entity.ChatRoom;
import ChatProject.DockSeosil.domain.chat.chatRoom.repository.ChatRoomRepository;
import ChatProject.DockSeosil.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

	private final ChatRoomRepository chatRoomRepository;

	@Transactional
	public Long make(String name) {

		ChatRoom chatRoom = ChatRoom.builder()
			.name(name)
			.build();

		chatRoomRepository.save(chatRoom);
		return chatRoom.getId();
	}

	public List<ChatRoomResponseDTO> findAllDTO() {
		return chatRoomRepository.findAll().stream()
			.map(room -> ChatRoomResponseDTO.builder()
				.id(room.getId())
				.name(room.getName())
				.createDate(room.getCreateDate())
				.modifyDate(room.getModifyDate())
				.build())
			.toList();
	}

	public ChatRoom findById(Long roomId) {
		return chatRoomRepository.findById(roomId)
			.orElseThrow(() -> new NotFoundException("채팅방이 존재하지 않습니다."));
	}

	@Transactional
	public void write(Long roomId, String writerName, String content) {
		ChatRoom chatRoom = chatRoomRepository.findById(roomId).get();

		chatRoom.writeMessage(writerName,content);
	}
}
