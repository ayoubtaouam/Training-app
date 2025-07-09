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
    private String name;
    @Enumerated(value = EnumType.STRING)
    private MicrocycleType type;
    @OneToMany(mappedBy = "microcycle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Session> sessions;
    @ManyToOne
    @JoinColumn(name = "mesocycle_id")
    private Mesocycle mesocycle;
}
