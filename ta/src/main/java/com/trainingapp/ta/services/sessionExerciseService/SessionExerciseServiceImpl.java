package com.trainingapp.ta.services.sessionExerciseService;

import com.trainingapp.ta.dtos.SessionExerciseDTO;
import com.trainingapp.ta.entities.SessionExercise;
import com.trainingapp.ta.mappers.SessionExerciseMapper;
import com.trainingapp.ta.repositories.SessionExerciseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @AllArgsConstructor
public class SessionExerciseServiceImpl implements SessionExerciseService {

    private SessionExerciseRepository sessionExerciseRepository;
    private SessionExerciseMapper sessionExerciseMapper;

    @Override
    public SessionExercise addSessionExercise(SessionExerciseDTO exercise) {
        return null;
    }

    @Override
    public SessionExerciseDTO getExercise(Long id) {
        return null;
    }

    @Override
    public List<SessionExerciseDTO> getAllExercises() {
        return null;
    }

    @Override
    public void deleteExercise(Long id) {

    }

    @Override
    public SessionExercise updateExerciseInfo(Long id, SessionExerciseDTO exerciseToUpdate) {
        return null;
    }
}
