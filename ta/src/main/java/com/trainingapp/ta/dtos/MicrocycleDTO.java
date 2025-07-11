package com.trainingapp.ta.dtos;

import com.trainingapp.ta.enums.MicrocycleType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class MicrocycleDTO {
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private MicrocycleType type;
    @Valid
    @NotEmpty
    private List<SessionDTO> sessions;
}
