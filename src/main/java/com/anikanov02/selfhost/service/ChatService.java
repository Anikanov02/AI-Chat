package com.anikanov02.selfhost.service;

import com.anikanov02.selfhost.domain.dto.chat.ChatBaseDto;
import com.anikanov02.selfhost.domain.dto.chat.ChatDto;
import com.anikanov02.selfhost.domain.dto.chat.ChatsPaginatedRequest;
import com.anikanov02.selfhost.domain.entity.Chat;
import com.anikanov02.selfhost.repository.ChatRepository;
import com.anikanov02.selfhost.util.mapper.ChatMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;
    private final ChatMapper chatMapper;
    private final UserService userService;

    public Chat getById(UUID id) {
        return chatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cant find chat with id: " + id));
    }

    public Page<ChatDto> getChats(ChatsPaginatedRequest request) {
        final PageRequest pageRequest = PageRequest.of(request.getPage(), request.getSize());
        return chatRepository.findAll(pageRequest).map(chatMapper::toDto);
    }

    public ChatDto getChat(UUID id) {
        return chatMapper.toDto(getById(id));
    }

    @Transactional
    public ChatDto createChat(ChatBaseDto dto) {
        return chatMapper.toDto(chatRepository.save(chatMapper.toEntity(dto, userService.getCurrentUser())));
    }

    @Transactional
    public ChatDto updateChat(UUID id, ChatBaseDto dto) {
        final Chat chat = getById(id);
        chatMapper.updateChat(getById(id), dto);
        return chatMapper.toDto(chatRepository.save(chat));
    }

    public void deleteChat(UUID id) {
        chatRepository.deleteById(id);
    }
}
