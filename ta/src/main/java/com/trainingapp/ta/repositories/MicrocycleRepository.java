package com.trainingapp.ta.repositories;

import com.trainingapp.ta.entities.Microcycle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MicrocycleRepository extends JpaRepository<Microcycle, Long> {
}
