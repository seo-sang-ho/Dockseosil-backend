package ChatProject.DockSeosil.domain.chat.chatRoom.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ChatProject.DockSeosil.domain.chat.chatRoom.entity.ChatRoom;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom,Long> {
}
