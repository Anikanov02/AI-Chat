package com.anikanov02.selfhost.service;

import com.anikanov02.selfhost.domain.dto.user.UserBaseDto;
import com.anikanov02.selfhost.domain.dto.user.UserDto;
import com.anikanov02.selfhost.domain.model.Chat;
import com.anikanov02.selfhost.domain.model.User;
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
        return userRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Cant find user with id: " + uuid));
    }

    public UserDto getUser(UUID uuid) {
        return userMapper.toDto(getById(uuid));
    }

    public UserDto createUser() {

    }

    public UserDto updateUser(UUID id, UserBaseDto dto) {
        final User user = getById(id);
        userMapper.updateUser(getById(id), dto);
        return userMapper.toDto(userRepository.save(user));
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
