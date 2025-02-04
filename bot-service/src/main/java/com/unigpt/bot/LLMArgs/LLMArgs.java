package com.unigpt.bot.LLMArgs;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unigpt.bot.model.BaseModelType;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class LLMArgs {
    private BaseModelType baseModelType;
    private Double temperature;

    LLMArgs() {
        
    }
    public static LLMArgsBuilder builder() {
        return new LLMArgsBuilder();
    }

    @JsonIgnore
    public Double getAdjustedTemperature() {
        return BaseModelType.GPT.equals(baseModelType) ? temperature * 2: temperature;
    }
}
