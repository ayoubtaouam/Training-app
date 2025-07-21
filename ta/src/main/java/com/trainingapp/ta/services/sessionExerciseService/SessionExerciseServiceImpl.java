package com.trainingapp.ta.services.sessionExerciseService;

import com.trainingapp.ta.dtos.SessionExerciseDTO;
import com.trainingapp.ta.entities.SessionExercise;
import com.trainingapp.ta.exceptions.costumExceptions.SessionExerciseNotFoundException;
import com.trainingapp.ta.mappers.SessionExerciseMapper;
import com.trainingapp.ta.repositories.SessionExerciseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service @AllArgsConstructor
public class SessionExerciseServiceImpl implements SessionExerciseService {

    private SessionExerciseRepository sessionExerciseRepository;
    private SessionExerciseMapper sessionExerciseMapper;

    @Override
    public SessionExercise addSessionExercise(SessionExerciseDTO exercise) {
        return sessionExerciseRepository.save(sessionExerciseMapper.toSessionExercise(exercise));
    }

    @Override
    public SessionExerciseDTO getExercise(Long id) {
        SessionExercise exercise = sessionExerciseRepository.findById(id).orElseThrow(() -> new SessionExerciseNotFoundException(id));
        return sessionExerciseMapper.toDTO(exercise);
    }

    @Override
    public List<SessionExerciseDTO> getAllExercises() {
        List<SessionExercise> exercises = sessionExerciseRepository.findAll();
        return exercises.stream().map(sessionExerciseMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteExercise(Long id) {
        if (!sessionExerciseRepository.existsById(id)) {
            throw new SessionExerciseNotFoundException(id);
        }
        sessionExerciseRepository.deleteById(id);
    }

    @Transactional
    @Override
    public SessionExercise updateExerciseInfo(Long id, SessionExerciseDTO updatedExerciseDTO) {
        SessionExercise exercise = sessionExerciseRepository.findById(id).orElseThrow(() -> new SessionExerciseNotFoundException(id));
        SessionExercise updatedExercise = sessionExerciseMapper.toSessionExercise(updatedExerciseDTO);
        exercise.setNotes(updatedExercise.getNotes());
        return sessionExerciseRepository.save(exercise);
    }
}
