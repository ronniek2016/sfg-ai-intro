package com.sfg.sfgaiintro.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public record GetCapitalInfoResponse(
        @JsonPropertyDescription("This is the capital of the country or state")
        String capital,
        @JsonPropertyDescription("This is the population of the city")
        String population,
        @JsonPropertyDescription("This is the region where capital is")
        String region,
        @JsonPropertyDescription("This is the language of the city")
        String language,
        @JsonPropertyDescription("This is the currency of the city")
        String currency
) {
}
