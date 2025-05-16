package com.anikanov02.selfhost.domain.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateDto extends UserBaseDto {
    @NotEmpty(message = "Login should not be empty")
    @Email(message = "Login should be an email")
    private String login;
    @Size(min = 8, max = 32, message = "Password should be > 8 and < 32 chars")
    private String password;
}
