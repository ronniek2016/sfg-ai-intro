package com.sfg.sfgaiintro.controllers;

import com.sfg.sfgaiintro.model.Answer;
import com.sfg.sfgaiintro.model.Question;
import com.sfg.sfgaiintro.services.OpenAIService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/questions-api")
public class QuestionController {

    @Autowired
    private OpenAIService openAIService;

    @PostMapping(path = "/ask")
    public Answer getAnswer(@RequestBody Question question) {
        return openAIService.getAnswer(question);
    }
}
