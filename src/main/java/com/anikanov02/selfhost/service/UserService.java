package com.anikanov02.selfhost.service;

import com.anikanov02.selfhost.dto.user.UserDto;
import com.anikanov02.selfhost.model.User;
import com.anikanov02.selfhost.repository.UserRepository;
import com.anikanov02.selfhost.util.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public User getById(UUID uuid) {

    }

    public UserDto getUser(UUID uuid) {
        return userMapper.toDto(getById(uuid));
    }

    public UserDto createUser() {

    }

    public UserDto updateUser() {

    }

    public void deleteUser() {

    }
}
