package com.trainingapp.ta.dtos;

import com.trainingapp.ta.enums.Unit;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class SetDTO {
    private Long id;
    @Min(1)
    private int reps;
    @DecimalMin("0.0")
    private double weight;
    @NotNull
    private Unit unit;
    private boolean isBodyWeight;
}
