package com.anikanov02.selfhost.controller;

import com.anikanov02.selfhost.dto.ChatDto;
import com.anikanov02.selfhost.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/chats")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;
    
    @GetMapping
    public ResponseEntity<Page<ChatDto>> getChats() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatDto> getChat(@PathVariable UUID id) {
        return ResponseEntity.ok().build();
    }
    
    @PostMapping
    public ResponseEntity<?> createChat() {
        return ResponseEntity.ok().build();
    }
    
    @PutMapping
    public ResponseEntity<?> updateChat() {
        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping
    public ResponseEntity<?> deleteChat() {
        return ResponseEntity.ok().build();
    }
}
