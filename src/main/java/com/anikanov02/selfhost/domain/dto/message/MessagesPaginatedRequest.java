package com.anikanov02.selfhost.domain.dto.message;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Getter
@Setter
public class MessagesPaginatedRequest {
    @NotNull(message = "Chat id is required")
    private UUID chatId;

    @NotNull(message = "Page is required")
    @Min(value = 1, message = "Page number must be greater than or equal to 1")
    private Integer page;
    @NotNull(message = "Size is required")
    @Min(value = 1, message = "Limit must be greater than or equal to 1")
    @Max(value = 100, message = "Limit must be less than or equal to 100")
    private Integer size;
}
