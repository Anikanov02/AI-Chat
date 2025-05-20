package com.anikanov02.selfhost.service;

import com.anikanov02.selfhost.domain.dto.model.ModelRequest;
import com.anikanov02.selfhost.domain.dto.model.ModelResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ModelCommunicationService {
    private final ChatClient chatClient;

    public ModelResponse getResponse(ModelRequest request) {
        final Prompt prompt = new Prompt(request.getInput(), ChatOptions.builder().model(request.getModel().getName()).build());

        final String response = this.chatClient.prompt(prompt)
                .call()
                .content();

        return new ModelResponse(response);
    }
}
