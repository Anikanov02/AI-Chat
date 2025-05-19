package com.anikanov02.selfhost.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserPermissionService {
    private final UserService userService;
    private final MessageService messageService;
    private final ChatService chatService;

    public boolean ownsChat(UUID chatId) {
        return Objects.equals(chatService.getById(chatId).getUser().getId(), userService.getCurrentUser().getId());
    }

    public boolean canModifyUser(UUID userId) {
        return Objects.equals(userId, userService.getCurrentUser().getId());
    }

    public boolean canModifyMessage(UUID messageId) {
        return Objects.equals(messageService.getById(messageId).getUser().getId(), userService.getCurrentUser().getId());
    }
}
