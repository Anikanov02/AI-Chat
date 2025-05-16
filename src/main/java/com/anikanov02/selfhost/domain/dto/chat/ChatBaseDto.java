package com.anikanov02.selfhost.domain.dto.chat;

import com.anikanov02.selfhost.domain.Model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatBaseDto {
    @NotBlank(message = "Message title should not be blank")
    @Size(max = 20, message = "Message title should not exceed 20 chars")
    private String title;

    private Model model;
}
