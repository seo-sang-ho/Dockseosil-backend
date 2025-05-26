package ChatProject.DockSeosil.domain.chat.chatRoom.dto;

import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class ChatRoomResponseDTO {
	private Long id;
	private String name;

	private LocalDateTime createDate;

	private LocalDateTime modifyDate;
}
