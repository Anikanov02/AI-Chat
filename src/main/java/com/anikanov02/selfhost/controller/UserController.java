package com.anikanov02.selfhost.controller;

import com.anikanov02.selfhost.dto.UserDto;
import com.anikanov02.selfhost.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<Page<UserDto>> getUsers() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable UUID id) {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> createUser() {
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<?> updateUser() {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser() {
        return ResponseEntity.ok().build();
    }
}
