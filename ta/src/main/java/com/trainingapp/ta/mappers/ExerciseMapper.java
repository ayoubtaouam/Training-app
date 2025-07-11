package com.trainingapp.ta.mappers;

import com.trainingapp.ta.dtos.ExerciseDTO;
import com.trainingapp.ta.entities.Exercise;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component @AllArgsConstructor
public class ExerciseMapper {
    private ModelMapper mapper;

    public Exercise toExercise(ExerciseDTO dto) {
        return mapper.map(dto, Exercise.class);
    }
    public ExerciseDTO toDTO(Exercise exercise) {
        return mapper.map(exercise, ExerciseDTO.class);
    }
}
