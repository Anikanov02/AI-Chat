package com.anikanov02.selfhost.service;

import com.anikanov02.selfhost.repository.MessageRepository;
import com.anikanov02.selfhost.util.mapper.MessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;
}
