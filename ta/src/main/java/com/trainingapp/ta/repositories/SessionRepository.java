package com.trainingapp.ta.repositories;

import com.trainingapp.ta.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
