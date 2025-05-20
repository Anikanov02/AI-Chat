package com.anikanov02.selfhost.service;

import com.anikanov02.selfhost.domain.dto.user.UserBaseDto;
import com.anikanov02.selfhost.domain.dto.user.UserDto;
import com.anikanov02.selfhost.domain.dto.user.UserSignupRequest;
import com.anikanov02.selfhost.domain.entity.User;
import com.anikanov02.selfhost.repository.UserRepository;
import com.anikanov02.selfhost.util.mapper.UserMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public User getById(UUID uuid) {
        return userRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Cant find user with id: " + uuid));
    }

    public User getByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Cant find user with email: " + email));
    }

    public UserDto getUser(UUID uuid) {
        return userMapper.toDto(getById(uuid));
    }

    public UserDto getUser(String email) {
        return userMapper.toDto(getByEmail(email));
    }

    @Transactional
    public UserDto createUser(UserSignupRequest request) {
        return userMapper.toDto(userRepository.save(userMapper.toEntity(request)));
    }

    @Transactional
    public UserDto updateUser(UUID id, UserBaseDto dto) {
        final User user = getById(id);
        userMapper.updateUser(getById(id), dto);
        return userMapper.toDto(userRepository.save(user));
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    public User getCurrentUser() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return getByEmail(authentication.getName());
    }
}
