package com.sfg.sfgaiintro.controllers;

import com.sfg.sfgaiintro.model.*;
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
    public GetCapitalResponse getCapital(@RequestBody GetCapitalRequest stateOrCountry) {
        return openAIService.getCapital(stateOrCountry);
    }

    @PostMapping(path="/get-capital-info")
    public GetCapitalInfoResponse getCapitalWithInfo(@RequestBody GetCapitalRequest stateOrCountry) {
        return openAIService.getCapitalWithInfo(stateOrCountry);
    }

    @PostMapping(path = "/ask")
    public Answer getAnswer(@RequestBody Question question) {
        return openAIService.getAnswer(question);
    }
}
