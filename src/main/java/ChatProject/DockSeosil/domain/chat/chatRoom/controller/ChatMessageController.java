package ChatProject.DockSeosil.domain.chat.chatRoom.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ChatProject.DockSeosil.domain.chat.chatRoom.dto.ChatRoomResponseDTO;
import ChatProject.DockSeosil.domain.chat.chatRoom.entity.ChatRoom;
import ChatProject.DockSeosil.domain.chat.chatRoom.service.ChatRoomService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/chat/room")
@RequiredArgsConstructor
public class ChatMessageController {

	private final ChatRoomService chatRoomService;

	@GetMapping("/{roomId}")
	@Transactional(readOnly = true)
	public ResponseEntity<ChatRoom> getRoomById(@PathVariable final Long roomId){
		ChatRoom findRoom = chatRoomService.findById(roomId);
		return ResponseEntity.ok(findRoom);
	}

	@PostMapping("/make")
	@Transactional
	public ResponseEntity<Map<String, Object>> make(@RequestBody Map<String, String> request) {
		String name = request.get("name");

		Long roomId = chatRoomService.make(name);

		return ResponseEntity.ok(Map.of(
			"message","채팅방이 생성되었습니다",
			"roomId",roomId
		));
	}

	@GetMapping("/list")
	@Transactional(readOnly = true)
	public ResponseEntity<List<ChatRoomResponseDTO>> list(){
		return ResponseEntity.ok(chatRoomService.findAllDTO());
	}

	@PostMapping("/{roomId}/write")
	@Transactional
	public ResponseEntity write(@PathVariable final Long roomId, final String writerName,final String content) {
		chatRoomService.write(roomId,writerName,content);
	}
}




