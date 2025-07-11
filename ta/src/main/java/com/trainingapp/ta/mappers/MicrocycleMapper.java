package com.trainingapp.ta.mappers;


import com.trainingapp.ta.dtos.MicrocycleDTO;
import com.trainingapp.ta.entities.Microcycle;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component @AllArgsConstructor
public class MicrocycleMapper {
    private ModelMapper mapper;

    public Microcycle toMicrocycle(MicrocycleDTO dto) {
        return mapper.map(dto, Microcycle.class);
    }
    public MicrocycleDTO toDTO(Microcycle microcycle) {
        return mapper.map(microcycle, MicrocycleDTO.class);
    }
}
