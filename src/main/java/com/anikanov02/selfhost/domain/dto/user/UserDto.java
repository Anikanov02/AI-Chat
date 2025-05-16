package com.anikanov02.selfhost.domain.dto.user;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserDto extends UserBaseDto {
    private UUID id;
}
