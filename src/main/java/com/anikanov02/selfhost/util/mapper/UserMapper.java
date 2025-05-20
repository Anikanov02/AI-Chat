package com.anikanov02.selfhost.util.mapper;

import com.anikanov02.selfhost.domain.dto.user.UserBaseDto;
import com.anikanov02.selfhost.domain.dto.user.UserDto;
import com.anikanov02.selfhost.domain.dto.user.UserSignupRequest;
import com.anikanov02.selfhost.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper
@RequiredArgsConstructor
public abstract class UserMapper {
    protected PasswordEncoder passwordEncoder;

    public abstract User toEntity(UserBaseDto dto);

    @Mapping(target = "password", qualifiedByName = "encodePassword")
    public abstract User toEntity(UserSignupRequest signupRequest);

    public abstract UserDto toDto(User user);

    public abstract void updateUser(User user, UserBaseDto userBaseDto);

    @Named("encodePassword")
    public String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    };
}
