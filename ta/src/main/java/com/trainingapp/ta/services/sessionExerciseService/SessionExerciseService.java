package com.trainingapp.ta.services.sessionExerciseService;

import com.trainingapp.ta.dtos.SessionExerciseDTO;
import com.trainingapp.ta.entities.SessionExercise;

import java.util.List;

public interface SessionExerciseService {
    SessionExercise addSessionExercise(SessionExerciseDTO exercise);
    SessionExerciseDTO getExercise(Long id);
    List<SessionExerciseDTO> getAllExercises();
    void deleteExercise(Long id);
    SessionExercise updateExerciseInfo(Long id, SessionExerciseDTO updatedExercise);
}
