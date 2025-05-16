package com.anikanov02.selfhost.service;

import com.anikanov02.selfhost.repository.ChatRepository;
import com.anikanov02.selfhost.util.mapper.ChatMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;
    private final ChatMapper chatMapper;


}
