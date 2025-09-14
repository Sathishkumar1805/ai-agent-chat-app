package com.example.aichat.controller;

import com.example.aichat.model.ChatMessage;
import com.example.aichat.service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public ResponseEntity<ChatMessage> chat(@RequestBody String userMessage) {
        ChatMessage chatMessage = chatService.chat(userMessage);
        return ResponseEntity.ok(chatMessage);
    }
}
