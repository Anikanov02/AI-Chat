package com.anikanov02.selfhost.controller;

import com.anikanov02.selfhost.domain.dto.chat.ChatBaseDto;
import com.anikanov02.selfhost.domain.dto.chat.ChatDto;
import com.anikanov02.selfhost.domain.dto.chat.ChatsPaginatedRequest;
import com.anikanov02.selfhost.service.ChatService;
import com.anikanov02.selfhost.service.UserPermissionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/chats")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;
    private final UserPermissionService permissionService;
    
    @GetMapping
    public ResponseEntity<Page<ChatDto>> getChats(@Valid ChatsPaginatedRequest request) {
        return ResponseEntity.ok(chatService.getChats(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatDto> getChat(@PathVariable UUID id) {
        if (permissionService.ownsChat(id)) {
            return ResponseEntity.ok(chatService.getChat(id));
        }
        throw new HttpClientErrorException(HttpStatus.FORBIDDEN, "You are not allowed to operate this chat");
    }
    
    @PostMapping
    public ResponseEntity<ChatDto> createChat(@RequestBody @Valid ChatBaseDto request) {
        return ResponseEntity.ok(chatService.createChat(request));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ChatDto> updateChat(@PathVariable UUID id, @RequestBody @Valid ChatBaseDto request) {
        if (permissionService.ownsChat(id)) {
            return ResponseEntity.ok(chatService.updateChat(id, request));
        }
        throw new HttpClientErrorException(HttpStatus.FORBIDDEN, "You are not allowed to operate this chat");
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChat(@PathVariable UUID id) {
        if (permissionService.ownsChat(id)) {
            chatService.deleteChat(id);
            return ResponseEntity.ok().build();
        }
        throw new HttpClientErrorException(HttpStatus.FORBIDDEN, "You are not allowed to operate this chat");
    }
}
