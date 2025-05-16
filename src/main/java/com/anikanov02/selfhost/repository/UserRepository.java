package com.anikanov02.selfhost.repository;

import com.anikanov02.selfhost.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
