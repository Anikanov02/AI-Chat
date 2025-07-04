package com.anikanov02.selfhost.repository;

import com.anikanov02.selfhost.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChatRepository extends JpaRepository<Chat, UUID> {
}
