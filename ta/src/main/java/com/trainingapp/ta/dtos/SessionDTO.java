package com.trainingapp.ta.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class SessionDTO {
    private Long id;
    @NotBlank
    private String name;
    private String description;
    @Valid
    @NotEmpty
    private List<SessionExerciseDTO> exercises;
}
