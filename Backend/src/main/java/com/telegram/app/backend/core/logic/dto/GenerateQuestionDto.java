package com.telegram.app.backend.core.logic.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.telegram.app.backend.core.enums.ActionType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GenerateQuestionDto {
    @NotNull
    @JsonProperty("action_type")
    private ActionType actionType;
}
