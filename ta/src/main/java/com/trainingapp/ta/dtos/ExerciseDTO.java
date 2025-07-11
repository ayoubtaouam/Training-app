package com.trainingapp.ta.dtos;

import com.trainingapp.ta.enums.Muscle;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class ExerciseDTO {
    private Long id;
    @NotBlank
    private String name;
    @NotEmpty
    private List<Muscle> muscles;
    private String description;
}
