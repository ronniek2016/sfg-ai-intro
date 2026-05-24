package com.sfg.sfgaiintro.controllers;

import com.sfg.sfgaiintro.model.Answer;
import com.sfg.sfgaiintro.model.GetCapitalRequest;
import com.sfg.sfgaiintro.model.Question;
import com.sfg.sfgaiintro.services.OpenAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/questions-api")
public class QuestionController {

    @Autowired
    private OpenAIService openAIService;

    @PostMapping(path="/get-capital")
    public Answer getCapital(@RequestBody GetCapitalRequest stateOrCountry) {
        return openAIService.getCapital(stateOrCountry);
    }

    @PostMapping(path="/get-capital-info")
    public Answer getCapitalWithInfo(@RequestBody GetCapitalRequest stateOrCountry) {
        return openAIService.getCapitalWithInfo(stateOrCountry);
    }

    @PostMapping(path = "/ask")
    public Answer getAnswer(@RequestBody Question question) {
        return openAIService.getAnswer(question);
    }
}
