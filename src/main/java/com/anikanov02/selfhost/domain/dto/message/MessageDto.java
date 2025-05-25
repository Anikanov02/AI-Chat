package com.anikanov02.selfhost.domain.dto.message;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class MessageDto extends MessageBaseDto {
    private UUID id;
    private boolean userMessage;
}
