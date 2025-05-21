package com.anikanov02.selfhost.domain.dto.chat;

import com.anikanov02.selfhost.domain.dto.PaginatedRequest;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ChatsPaginatedRequest extends PaginatedRequest {
    @NotNull(message = "User id is required")
    private UUID userId;
}
