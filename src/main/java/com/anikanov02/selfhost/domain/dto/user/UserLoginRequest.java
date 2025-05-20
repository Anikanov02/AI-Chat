package com.anikanov02.selfhost.domain.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginRequest {
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Login should be an email")
    private String login;
    @NotEmpty(message = "Password should not be empty")
    private String password;
}
