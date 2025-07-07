package com.trainingapp.ta.repositories;

import com.trainingapp.ta.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
