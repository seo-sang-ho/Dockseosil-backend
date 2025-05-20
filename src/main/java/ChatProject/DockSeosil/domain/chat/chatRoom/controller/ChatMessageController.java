package ChatProject.DockSeosil.domain.chat.chatRoom.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ChatProject.DockSeosil.domain.chat.chatRoom.entity.ChatRoom;
import ChatProject.DockSeosil.domain.chat.chatRoom.service.ChatRoomService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/chat/room")
@RequiredArgsConstructor
public class ChatMessageController {

	private final ChatRoomService chatRoomService;

	@GetMapping("/{roomId}")
	@ResponseBody
	public ResponseEntity<ChatRoom> getRoomById(@PathVariable final Long roomId){
		ChatRoom findRoom = chatRoomService.findById(roomId);
		return ResponseEntity.ok(findRoom);
	}

	@GetMapping("/make")
	public String showMake(){
		return "chat/chatRoom/make";
	}

	@PostMapping("/make")
	public String make(final String name){
		chatRoomService.make(name);
		return "redirect:/api/chat/room/make";
	}

	@GetMapping("/list")
	@ResponseBody
	public List<ChatRoom> list(){
		List<ChatRoom> roomList = chatRoomService.findAll();
		return roomList;
	}
}
