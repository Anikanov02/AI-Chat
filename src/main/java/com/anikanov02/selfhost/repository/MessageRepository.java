package com.anikanov02.selfhost.repository;

import com.anikanov02.selfhost.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MessageRepository extends JpaRepository<Message, UUID> {
}
