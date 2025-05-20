package com.anikanov02.selfhost.domain.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBaseDto {
    @NotBlank(message = "First name should not be blank")
    @Size(max = 40, message = "First name should not exceed 40 chars")
    @JsonProperty("first_name")
    private String firstName;
    @NotEmpty(message = "Last name should not be blank")
    @Size(max = 40, message = "Last name should not exceed 40 chars")
    @JsonProperty("last_name")
    private String lastName;
}
