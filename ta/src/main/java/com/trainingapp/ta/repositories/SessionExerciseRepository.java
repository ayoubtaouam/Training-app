package com.trainingapp.ta.repositories;

import com.trainingapp.ta.entities.SessionExercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionExerciseRepository extends JpaRepository<SessionExercise, Long> {
}
