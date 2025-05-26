package ChatProject.DockSeosil.domain.chat.chatRoom.entity;

import static jakarta.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class ChatRoom {

	@Id @GeneratedValue(strategy = IDENTITY)
	private Long id;

	private String name;

	@CreatedDate
	private LocalDateTime createDate;

	@LastModifiedDate
	private LocalDateTime modifyDate;

	@OneToMany(mappedBy = "chatRoom", cascade = CascadeType.ALL, orphanRemoval = true)
	@Builder.Default
	private List<ChatMessage> chatMessages = new ArrayList<>();

	public void writeMessage(String writerName, String content) {
		ChatMessage chatMessage = ChatMessage
			.builder()
			.chatRoom(this)
			.writerName(writerName)
			.content(content)
			.build();

		chatMessages.add(chatMessage);
	}
}
