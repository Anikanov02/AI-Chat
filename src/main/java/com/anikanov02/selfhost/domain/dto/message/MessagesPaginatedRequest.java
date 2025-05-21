package com.anikanov02.selfhost.domain.dto.message;

import com.anikanov02.selfhost.domain.dto.PaginatedRequest;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class MessagesPaginatedRequest extends PaginatedRequest {
    @NotNull(message = "Chat id is required")
    private UUID chatId;
}
