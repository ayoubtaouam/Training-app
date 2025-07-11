package com.trainingapp.ta.mappers;

import com.trainingapp.ta.dtos.MesocycleDTO;
import com.trainingapp.ta.entities.Mesocycle;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component @AllArgsConstructor
public class MesocycleMapper {
    private ModelMapper mapper;

    public Mesocycle toMesocycle(MesocycleDTO dto) {
        return mapper.map(dto, Mesocycle.class);
    }
    public MesocycleDTO toDTO(Mesocycle mesocycle) {
        return mapper.map(mesocycle, MesocycleDTO.class);
    }
}
