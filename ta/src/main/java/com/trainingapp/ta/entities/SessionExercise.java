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
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;
    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Set> sets;
    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;
    private int order;
}
