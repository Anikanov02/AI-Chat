package com.anikanov02.selfhost.controller;

import com.anikanov02.selfhost.domain.dto.message.MessageDto;
import com.anikanov02.selfhost.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @GetMapping
    public ResponseEntity<Page<MessageDto>> getMessages() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDto> getMessage(@PathVariable UUID id) {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> createMessage() {
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<?> updateMessage() {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteMessage() {
        return ResponseEntity.ok().build();
    }
}
