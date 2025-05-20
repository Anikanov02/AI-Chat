package com.anikanov02.selfhost.domain.dto.model;

import com.anikanov02.selfhost.domain.Model;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public abstract class ModelRequest {
    private Model model;
    private String input;
}
