package com.anikanov02.selfhost.service;

import com.anikanov02.selfhost.repository.UserRepository;
import com.anikanov02.selfhost.util.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
}
