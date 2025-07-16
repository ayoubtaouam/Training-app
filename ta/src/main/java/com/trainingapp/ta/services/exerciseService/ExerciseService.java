package com.trainingapp.ta.services.exerciseService;

import com.trainingapp.ta.dtos.ExerciseDTO;
import com.trainingapp.ta.entities.Exercise;

import java.util.List;

public interface ExerciseService {
    Exercise addExercise(ExerciseDTO exercise);
    List<ExerciseDTO> getAllExercises();
    ExerciseDTO getExercise(Long id);
    void deleteExercise(Long id);
    Exercise updateExercise(Long id, ExerciseDTO exerciseToUpdate);
}
