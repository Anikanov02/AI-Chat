package com.anikanov02.selfhost.util.mapper;

import com.anikanov02.selfhost.domain.dto.user.UserBaseDto;
import com.anikanov02.selfhost.domain.dto.user.UserDto;
import com.anikanov02.selfhost.domain.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User toEntity(UserBaseDto dto);
    UserDto toDto(User user);
    void updateUser(User user, UserBaseDto userBaseDto);
}
