package com.anikanov02.selfhost.service;

import com.anikanov02.selfhost.domain.Model;
import com.anikanov02.selfhost.domain.dto.model.ModelRequest;
import com.anikanov02.selfhost.domain.dto.model.ModelResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@ConditionalOnProperty(value = "app.model-provider", havingValue = "OLLAMA")
public class OllamaCommunicationService implements ModelCommunicationService {
    private final OllamaChatModel chatClient;

    @Override
    public ModelResponse getResponse(ModelRequest request) {
        final Prompt prompt = new Prompt(request.getInput(), ChatOptions.builder().model(getModelName(request.getModel())).build());

        return chatClient.call(prompt).getResult().getOutput().;
    }

    private String getModelName(Model model) {
        return null;
    }
}
