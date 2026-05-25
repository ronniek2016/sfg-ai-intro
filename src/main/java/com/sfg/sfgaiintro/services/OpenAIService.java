package com.sfg.sfgaiintro.services;

import com.sfg.sfgaiintro.model.*;

public interface OpenAIService {

    String getAnswer(String question);

    Answer getAnswer(Question question);

    GetCapitalResponse getCapital(GetCapitalRequest stateOrCountry);

    GetCapitalInfoResponse getCapitalWithInfo(GetCapitalRequest stateOrCountry);
}
