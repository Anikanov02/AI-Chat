package com.anikanov02.selfhost.domain.dto.message;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageBaseDto {
    @NotBlank(message = "Message text should not be blank")
    @Size(max = 5000, message = "Message text should not exceed 5000 chars")
    private String text;
}
