package com.trainingapp.ta.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class SessionExerciseDTO {

    private Long id;
    private Long exerciseId;
    private String notes;
    @Valid
    @NotEmpty
    private List<SetDTO> sets;
}
