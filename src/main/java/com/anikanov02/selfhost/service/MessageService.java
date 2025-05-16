package com.anikanov02.selfhost.service;

import com.anikanov02.selfhost.domain.dto.message.MessageBaseDto;
import com.anikanov02.selfhost.domain.dto.message.MessageDto;
import com.anikanov02.selfhost.domain.dto.message.MessagesPaginatedRequest;
import com.anikanov02.selfhost.domain.model.Chat;
import com.anikanov02.selfhost.domain.model.Message;
import com.anikanov02.selfhost.domain.model.User;
import com.anikanov02.selfhost.repository.MessageRepository;
import com.anikanov02.selfhost.util.mapper.MessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final ChatService chatService;
    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    public Message getById(UUID uuid) {
        return messageRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Cant find message with id: " + uuid));
    }

    public Page<Message> getMessages(MessagesPaginatedRequest request) {
        final PageRequest pageRequest = PageRequest.of(request.getPage(), request.getSize());
        return messageRepository.findAll(pageRequest);
    }

    public MessageDto getMessage(UUID uuid) {
        return messageMapper.toDto(getById(uuid));
    }

    public MessageDto createMessage(MessageBaseDto dto, UUID chatId) {
        final Chat chat = chatService.getById(chatId);
        return messageMapper.toDto(messageRepository.save(messageMapper.toEntity(dto, chat)));
    }

    public MessageDto updateMessage(UUID id, MessageBaseDto dto) {
        final Message message = getById(id);
        messageMapper.updateMessage(getById(id), dto);
        return messageMapper.toDto(messageRepository.save(message));
    }

    public void deleteMessage(UUID id) {
        messageRepository.deleteById(id);
    }
}
