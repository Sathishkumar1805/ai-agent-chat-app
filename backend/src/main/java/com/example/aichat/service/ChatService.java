package com.example.aichat.service;

import com.example.aichat.model.ChatMessage;
import com.example.aichat.repository.ChatMessageRepository;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class ChatService {
    private final ChatMessageRepository chatMessageRepository;
    private final OpenAiChatClient openAiChatClient;

    public ChatService(ChatMessageRepository chatMessageRepository, OpenAiChatClient openAiChatClient) {
        this.chatMessageRepository = chatMessageRepository;
        this.openAiChatClient = openAiChatClient;
    }

    @Transactional
    public ChatMessage chat(String userMessage) {
        String aiResponse = openAiChatClient.call(userMessage);
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUserMessage(userMessage);
        chatMessage.setAiResponse(aiResponse);
        chatMessage.setTimestamp(LocalDateTime.now());
        return chatMessageRepository.save(chatMessage);
    }
}
