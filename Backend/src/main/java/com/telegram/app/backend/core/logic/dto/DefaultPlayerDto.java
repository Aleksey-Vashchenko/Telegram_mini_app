package com.telegram.app.backend.core.logic.dto;

import com.telegram.app.backend.core.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class DefaultPlayerDto {
    @NotNull
    private Integer id;
    @NotNull @NotBlank
    private String name;
    @NotNull
    private Gender gender;
    @NotNull
    private List<Gender> preferredGenders;
    private Short pairId;
    private Short levelFrom;
    private Short levelTo;
    private List<Short> packages;

}
