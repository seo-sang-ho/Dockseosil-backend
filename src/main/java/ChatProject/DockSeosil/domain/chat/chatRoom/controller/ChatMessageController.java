package ChatProject.DockSeosil.domain.chat.chatRoom.controller;

import java.util.List;

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
@RequestMapping("/chat/room")
@RequiredArgsConstructor
public class ChatMessageController {

	private final ChatRoomService chatRoomService;

	@GetMapping("/{roomId}")
	@ResponseBody
	public String showRoom(
			@PathVariable final Long roomId,
			@RequestParam(defaultValue = "NoName") final String writerName
 		){
		return "%d번 채팅방입니다. writer : %s".formatted(roomId,writerName);
	}

	@GetMapping("/make")
	public String showMake(){
		return "chat/chatRoom/make";
	}

	@PostMapping("/make")
	public String make(final String name){
		chatRoomService.make(name);
		return "redirect:/chat/room/make";
	}

	@GetMapping("/list")
	@ResponseBody
	public List<ChatRoom> list(){
		List<ChatRoom> roomList = chatRoomService.findAll();
		return roomList;
	}
}
