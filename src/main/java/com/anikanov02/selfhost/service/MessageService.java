package com.anikanov02.selfhost.service;

import com.anikanov02.selfhost.dto.message.MessageDto;
import com.anikanov02.selfhost.dto.message.MessagesPaginatedRequest;
import com.anikanov02.selfhost.model.Message;
import com.anikanov02.selfhost.repository.MessageRepository;
import com.anikanov02.selfhost.util.mapper.MessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    public Message getById(UUID uuid) {

    }

    public Page<Message> getMessages(MessagesPaginatedRequest request) {

    }

    public MessageDto getMessage(UUID uuid) {
        return messageMapper.toDto(getById(uuid));
    }

    public MessageDto createMessage() {

    }

    public MessageDto updateMessage() {

    }

    public void deleteMessage() {

    }
}
