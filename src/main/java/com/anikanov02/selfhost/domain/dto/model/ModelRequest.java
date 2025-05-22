package com.anikanov02.selfhost.domain.dto.model;

import com.anikanov02.selfhost.domain.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ModelRequest {
    private Model model;
    private String input;
    private UUID chatId;
}
