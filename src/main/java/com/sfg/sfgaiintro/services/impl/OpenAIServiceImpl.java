package com.sfg.sfgaiintro.services.impl;

import tools.jackson.databind.json.JsonMapper;
import com.sfg.sfgaiintro.model.Answer;
import com.sfg.sfgaiintro.model.GetCapitalRequest;
import com.sfg.sfgaiintro.model.PromptsConfig;
import com.sfg.sfgaiintro.model.Question;
import com.sfg.sfgaiintro.services.OpenAIService;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

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
    public Answer getCapital(GetCapitalRequest stateOrCountry) {
        PromptTemplate promptTemplate = new PromptTemplate(promptsConfig.getCapitalPromptJson);
        Prompt prompt = promptTemplate.create(Map.of("stateOrCountry", stateOrCountry.stateOrCountry()));
        ChatResponse chatResponse = chatModel.call(prompt);
        return jsonMapper.readValue(chatResponse.getResult().getOutput().getText(), Answer.class);
    }

    @Override
    public Answer getCapitalWithInfo(GetCapitalRequest stateOrCountry) {
        PromptTemplate promptTemplate = new PromptTemplate(promptsConfig.getCapitalWithInfo);
        Prompt prompt = promptTemplate.create(Map.of("stateOrCountry", stateOrCountry.stateOrCountry()));
        ChatResponse chatResponse = chatModel.call(prompt);
        return new Answer(chatResponse.getResult().getOutput().getText());
    }
}
