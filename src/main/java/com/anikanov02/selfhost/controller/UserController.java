package com.anikanov02.selfhost.controller;

import com.anikanov02.selfhost.domain.dto.user.UserBaseDto;
import com.anikanov02.selfhost.domain.dto.user.UserDto;
import com.anikanov02.selfhost.service.UserPermissionService;
import com.anikanov02.selfhost.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserPermissionService permissionService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable UUID id) {
        if (permissionService.canModifyUser(id)) {
            return ResponseEntity.ok(userService.getUser(id));
        }
        throw new HttpClientErrorException(HttpStatus.FORBIDDEN, "You are not allowed to operate this user");
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable UUID id, @RequestBody @Valid UserBaseDto request) {
        if (permissionService.canModifyUser(id)) {
            return ResponseEntity.ok(userService.updateUser(id, request));
        }
        throw new HttpClientErrorException(HttpStatus.FORBIDDEN, "You are not allowed to operate this user");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        if (permissionService.canModifyUser(id)) {
            userService.deleteUser(id);
            return ResponseEntity.ok().build();
        }
        throw new HttpClientErrorException(HttpStatus.FORBIDDEN, "You are not allowed to operate this user");
    }
}
