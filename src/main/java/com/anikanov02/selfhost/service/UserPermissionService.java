package com.anikanov02.selfhost.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserPermissionService {
    public boolean ownsChat(UUID userId, UUID chatId) {
        return true;
    }
}
