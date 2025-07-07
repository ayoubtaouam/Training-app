package com.trainingapp.ta.entities;

import com.trainingapp.ta.enums.MicrocycleType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity @Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Microcycle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private MicrocycleType type;
    @OneToMany
    private List<Session> sessions;
}
