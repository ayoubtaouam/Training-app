package com.trainingapp.ta.repositories;

import com.trainingapp.ta.entities.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
