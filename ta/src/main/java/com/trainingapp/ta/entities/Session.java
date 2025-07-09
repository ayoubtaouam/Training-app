package com.trainingapp.ta.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity @Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SessionExercise> exercises;
    @ManyToOne
    @JoinColumn(name = "microcycle_id")
    private Microcycle microcycle;
}
