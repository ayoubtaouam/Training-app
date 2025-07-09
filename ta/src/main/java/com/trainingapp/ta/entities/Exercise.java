package com.trainingapp.ta.entities;

import com.trainingapp.ta.enums.Muscle;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ElementCollection(targetClass = Muscle.class)
    @Enumerated(value = EnumType.STRING)
    private List<Muscle> muscles;
    private String description;
}
