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
    private Short difficultyFrom;
    private Short difficultyTo;
    @NotNull
    private List<Short> packages;

    // Getters and Setters
}
