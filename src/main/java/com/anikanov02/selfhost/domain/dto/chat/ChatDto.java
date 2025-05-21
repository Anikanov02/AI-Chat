package com.anikanov02.selfhost.domain.dto.chat;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ChatDto extends ChatBaseDto {
    private UUID id;
}
