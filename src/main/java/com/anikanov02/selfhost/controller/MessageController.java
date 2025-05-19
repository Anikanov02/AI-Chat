package com.anikanov02.selfhost.controller;

import com.anikanov02.selfhost.domain.dto.message.MessageBaseDto;
import com.anikanov02.selfhost.domain.dto.message.MessageDto;
import com.anikanov02.selfhost.domain.dto.message.MessagesPaginatedRequest;
import com.anikanov02.selfhost.service.MessageService;
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
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;
    private final UserPermissionService permissionService;

    @GetMapping
    public ResponseEntity<Page<MessageDto>> getMessages(MessagesPaginatedRequest request) {
        return ResponseEntity.ok(messageService.getMessages(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDto> getMessage(@PathVariable UUID id) {
        if (permissionService.canModifyMessage(id)) {
            return ResponseEntity.ok(messageService.getMessage(id));
        }
        throw new HttpClientErrorException(HttpStatus.FORBIDDEN, "You are not allowed to operate this message");
    }

    @PostMapping
    public ResponseEntity<?> createMessage(@RequestParam UUID chatId, @RequestBody @Valid MessageBaseDto request) {
        if (permissionService.ownsChat(chatId)) {
            return ResponseEntity.ok(messageService.createMessage(request, chatId));
        }
        throw new HttpClientErrorException(HttpStatus.FORBIDDEN, "You are not allowed to operate this chat");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMessage(@PathVariable UUID id, @RequestBody @Valid MessageBaseDto request) {
        if (permissionService.canModifyMessage(id)) {
            return ResponseEntity.ok(messageService.updateMessage(id, request));
        }
        throw new HttpClientErrorException(HttpStatus.FORBIDDEN, "You are not allowed to operate this message");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMessage(@PathVariable UUID id) {
        if (permissionService.canModifyMessage(id)) {
            messageService.deleteMessage(id);
            return ResponseEntity.ok().build();
        }
        throw new HttpClientErrorException(HttpStatus.FORBIDDEN, "You are not allowed to operate this message");
    }
}
