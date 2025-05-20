package com.anikanov02.selfhost.service;

import com.anikanov02.selfhost.domain.dto.model.ModelRequest;
import com.anikanov02.selfhost.domain.dto.model.ModelResponse;

public interface ModelCommunicationService {
    ModelResponse getResponse(ModelRequest t);
}
