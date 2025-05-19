package com.anikanov02.selfhost.domain.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginRequest {
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be an email")
    private String login;
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be an email")
    private String password;
}
