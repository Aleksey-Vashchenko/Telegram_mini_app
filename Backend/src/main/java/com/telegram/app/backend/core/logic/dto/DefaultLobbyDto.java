package com.telegram.app.backend.core.logic.dto;

import com.telegram.app.backend.core.enums.SettingsMode;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class DefaultLobbyDto {
    @NotNull
    private String lang;
    @NotNull
    private SettingsMode gameType;
    @NotNull
    private List<DefaultPlayerDto> players;
    private Integer difficultyFrom;
    private Integer difficultyTo;
    @NotNull
    private List<Integer> packages;

    // Getters and Setters
}
