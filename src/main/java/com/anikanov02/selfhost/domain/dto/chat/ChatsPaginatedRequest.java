package com.anikanov02.selfhost.domain.dto.chat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatsPaginatedRequest {
    private Integer page;
    private Integer size;
}
