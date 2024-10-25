package com.telegram.app.backend.core.logic.dto;

import com.telegram.app.backend.core.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class DefaultPlayerDto {
    @NotNull
    private Integer id;
    @NotNull @NotBlank
    private String name;
    @NotNull
    private Gender gender;
    @NotNull
    private List<Gender> preferred;
    private Integer pair;
    private Integer difficultyTo;
    private List<Integer> packages;

}
