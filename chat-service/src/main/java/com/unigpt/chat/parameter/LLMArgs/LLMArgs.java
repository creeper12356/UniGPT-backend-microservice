package com.unigpt.chat.parameter.LLMArgs;

import com.unigpt.chat.model.BaseModelType;

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

    public Double getAdjustedTemperature() {
        return BaseModelType.GPT.equals(baseModelType) ? temperature * 2 : temperature;
    }
}
