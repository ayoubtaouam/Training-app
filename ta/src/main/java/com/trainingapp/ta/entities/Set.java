package com.trainingapp.ta.entities;

import com.trainingapp.ta.enums.Unit;
import jakarta.persistence.*;
import lombok.*;

@Entity @Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Set {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int reps;
    private double weight;
    @Enumerated(value = EnumType.STRING)
    private Unit unit;
    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private SessionExercise exercise;
    private boolean isBodyWeight;
}
