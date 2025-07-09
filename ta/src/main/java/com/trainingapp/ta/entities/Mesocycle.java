package com.trainingapp.ta.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity @Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mesocycle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "mesocycle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Microcycle> microcycles;
}
