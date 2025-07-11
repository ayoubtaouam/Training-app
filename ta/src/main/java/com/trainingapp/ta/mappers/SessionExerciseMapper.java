package com.trainingapp.ta.mappers;

import com.trainingapp.ta.dtos.SessionExerciseDTO;
import com.trainingapp.ta.entities.SessionExercise;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component @AllArgsConstructor
public class SessionExerciseMapper {
    private ModelMapper mapper;

    public SessionExercise toSessionExercise(SessionExerciseDTO dto) {
        return mapper.map(dto, SessionExercise.class);
    }
    public SessionExerciseDTO toDTO(SessionExercise exercise) {
        return mapper.map(exercise, SessionExerciseDTO.class);
    }
}
