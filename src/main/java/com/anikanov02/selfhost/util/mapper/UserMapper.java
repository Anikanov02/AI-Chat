package com.anikanov02.selfhost.util.mapper;

import com.anikanov02.selfhost.dto.UserDto;
import com.anikanov02.selfhost.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User toEntity(UserDto dto);
    UserDto toDto(User user);
}
