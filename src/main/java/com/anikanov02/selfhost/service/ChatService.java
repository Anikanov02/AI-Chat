package com.anikanov02.selfhost.service;

import com.anikanov02.selfhost.dto.chat.ChatDto;
import com.anikanov02.selfhost.dto.chat.ChatsPaginatedRequest;
import com.anikanov02.selfhost.model.Chat;
import com.anikanov02.selfhost.repository.ChatRepository;
import com.anikanov02.selfhost.util.mapper.ChatMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;
    private final ChatMapper chatMapper;

    public Chat getById(UUID uuid) {

    }

    public Page<Chat> getChats(ChatsPaginatedRequest request) {

    }

    public ChatDto getChat(UUID uuid) {
        return chatMapper.toDto(getById(uuid));
    }

    public ChatDto createChat() {

    }

    public ChatDto updateChat() {

    }

    public void deleteChat() {

    }
}
