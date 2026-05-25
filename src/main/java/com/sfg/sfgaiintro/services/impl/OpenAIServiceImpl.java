package com.sfg.sfgaiintro.services.impl;

import com.sfg.sfgaiintro.model.*;
import org.springframework.ai.converter.BeanOutputConverter;
import tools.jackson.databind.json.JsonMapper;
import com.sfg.sfgaiintro.services.OpenAIService;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class OpenAIServiceImpl implements OpenAIService {

    @Autowired
    private ChatModel chatModel;

    @Autowired
    private PromptsConfig promptsConfig;

    @Autowired
    private JsonMapper jsonMapper;

    @Override
    public String getAnswer(String question) {

        PromptTemplate promptTemplate = new PromptTemplate(question);
        Prompt prompt = promptTemplate.create();

        ChatResponse chatResponse = chatModel.call(prompt);

        return chatResponse.getResult().getOutput().getText();
    }

    public Answer getAnswer(Question question) {
        return new Answer(getAnswer(question.question()));
    }

    @Override
    public GetCapitalResponse getCapital(GetCapitalRequest stateOrCountry) {
        BeanOutputConverter<GetCapitalResponse> converter = new BeanOutputConverter<>(GetCapitalResponse.class);
        PromptTemplate promptTemplate = new PromptTemplate(promptsConfig.getCapitalPromptJson);
        Prompt prompt = promptTemplate.create(Map.of("stateOrCountry", stateOrCountry.stateOrCountry()
                , "format", converter.getFormat()));
        ChatResponse chatResponse = chatModel.call(prompt);
        return converter.convert(Objects.requireNonNull(chatResponse.getResult().getOutput().getText()));
    }

    @Override
    public GetCapitalInfoResponse getCapitalWithInfo(GetCapitalRequest stateOrCountry) {
        BeanOutputConverter<GetCapitalInfoResponse> converter = new BeanOutputConverter<>(GetCapitalInfoResponse.class);
        PromptTemplate promptTemplate = new PromptTemplate(promptsConfig.getCapitalWithInfoJson);
        Prompt prompt = promptTemplate.create(Map.of("stateOrCountry", stateOrCountry.stateOrCountry(),
                "format", converter.getFormat()));
        ChatResponse chatResponse = chatModel.call(prompt);
        return converter.convert(Objects.requireNonNull(chatResponse.getResult().getOutput().getText()));
    }
}
