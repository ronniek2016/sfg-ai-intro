package com.sfg.sfgaiintro.services;

import com.sfg.sfgaiintro.model.Answer;
import com.sfg.sfgaiintro.model.Question;

public interface OpenAIService {

    String getAnswer(String question);

    Answer getAnswer(Question question);
}
