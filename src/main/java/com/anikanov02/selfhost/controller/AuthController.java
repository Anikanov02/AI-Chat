package com.anikanov02.selfhost.controller;

import com.anikanov02.selfhost.domain.dto.user.UserDto;
import com.anikanov02.selfhost.domain.dto.user.UserLoginRequest;
import com.anikanov02.selfhost.domain.dto.user.UserSignupRequest;
import com.anikanov02.selfhost.service.SecurityService;
import com.anikanov02.selfhost.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final UserService userService;
    private final SecurityService securityService;

    @PostMapping("/sign-in")
    public ResponseEntity<UserDto> signIn(@RequestBody @Valid UserLoginRequest request) {
        securityService.login(request.getLogin(), request.getPassword());
        log.info("logged new user: " + request.getLogin());
        return ResponseEntity.ok(userService.getUser(request.getLogin()));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> signup(@RequestBody @Valid UserSignupRequest request) {
        final UserDto userDto = userService.createUser(request);
        log.debug("registered new user: " + request.getEmail());
        securityService.login(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(userDto);
    }
}
