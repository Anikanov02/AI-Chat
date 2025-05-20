package com.anikanov02.selfhost.domain.dto.message;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageBaseDto {
    @NotBlank(message = "Message text should not be blank")
    @Size(max = 5000, message = "Message text should not exceed 5000 chars")
    private String text;
}
