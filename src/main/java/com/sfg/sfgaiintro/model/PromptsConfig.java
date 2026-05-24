package com.sfg.sfgaiintro.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:templates/prompts.st")
public class PromptsConfig {

    @Value("${get-capital-prompt}")
    public String getCapitalPrompt;

    @Value("${get-capital-with-info}")
    public String getCapitalWithInfo;
}
