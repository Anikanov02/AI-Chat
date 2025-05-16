package com.anikanov02.selfhost.domain.dto.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessagesPaginatedRequest {
    private Integer page;
    private Integer size;
}
