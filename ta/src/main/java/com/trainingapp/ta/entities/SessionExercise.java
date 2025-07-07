package com.trainingapp.ta.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity @Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SessionExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String notes;
    @OneToOne
    private Exercise exercise;
    @OneToMany
    private List<Set> sets;
}
