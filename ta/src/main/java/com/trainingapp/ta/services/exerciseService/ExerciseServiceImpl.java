package com.trainingapp.ta.services.exerciseService;

import com.trainingapp.ta.dtos.ExerciseDTO;
import com.trainingapp.ta.entities.Exercise;
import com.trainingapp.ta.exceptions.costumExceptions.ExerciseNotFoundException;
import com.trainingapp.ta.mappers.ExerciseMapper;
import com.trainingapp.ta.repositories.ExerciseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service @AllArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {
    private ExerciseRepository exerciseRepository;
    private ExerciseMapper exerciseMapper;
    @Override
    public Exercise addExercise(ExerciseDTO exercise) {
        return exerciseRepository.save(exerciseMapper.toExercise(exercise));
    }

    @Override
    public List<ExerciseDTO> getAllExercises() {
        List<Exercise> exercises = exerciseRepository.findAll();
        return exercises.stream().map(e -> exerciseMapper.toDTO(e)).collect(Collectors.toList());
    }

    @Override
    public ExerciseDTO getExercise(Long id) {
        Exercise exercise = exerciseRepository.findById(id).orElseThrow(() -> new ExerciseNotFoundException(id));
        return exerciseMapper.toDTO(exercise);
    }

    @Override
    public void deleteExercise(Long id) {
        Exercise exercise = exerciseRepository.findById(id).orElseThrow(() -> new ExerciseNotFoundException(id));
        exerciseRepository.deleteById(id);
    }

    @Override
    public Exercise updateExercise(Long id, ExerciseDTO exerciseToUpdate) {
        Exercise exercise = exerciseRepository.findById(id).orElseThrow(() -> new ExerciseNotFoundException(id));
        exercise.setName(exerciseMapper.toExercise(exerciseToUpdate).getName());
        exercise.setDescription(exerciseMapper.toExercise(exerciseToUpdate).getDescription());
        exercise.setMuscles(exerciseMapper.toExercise(exerciseToUpdate).getMuscles());
        return exerciseRepository.save(exercise);
    }
}
