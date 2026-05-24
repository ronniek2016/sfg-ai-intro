package com.sfg.sfgaiintro.services.impl;

import com.sfg.sfgaiintro.services.OpenAIService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OpenAIServiceImplTest {

    @Autowired
    private OpenAIService openAIService;

    @Test
    void getAnswer() {
        String result = openAIService.getAnswer("2 + 2");
        System.out.println(result);
    }
}