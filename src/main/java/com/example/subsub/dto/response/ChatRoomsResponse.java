package com.example.subsub.dto.response;

import com.example.subsub.domain.ChatRoom;
import com.example.subsub.domain.UserType;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChatRoomsResponse {
    private Integer id;
    private String roomId;
    private String postTitle;
    private UserType userType;
    private String borrowerNickname;
    private String lenderNickname;
    private String lastMessage;
    private LocalDateTime lastMessageTime;

    @Builder
    public ChatRoomsResponse(ChatRoom chatRoom,UserType userType, String lastMessage, LocalDateTime lastMessageTime){
        id = chatRoom.getId();
        roomId = chatRoom.getRoomId();
        postTitle = chatRoom.getPost().getTitle();
        this.userType = userType;
        borrowerNickname = chatRoom.getBorrower().getNickName();
        lenderNickname = chatRoom.getLender().getNickName();
        this.lastMessage = lastMessage;
        this.lastMessageTime = lastMessageTime;
    }
}
