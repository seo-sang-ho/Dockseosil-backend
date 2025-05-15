package ChatProject.DockSeosil.domain.chat.chatRoom.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
public class ChatRoom {

	@Setter
	private Long id;

	private String name;

	public ChatRoom(String name){
		this.name = name;
	}
}
