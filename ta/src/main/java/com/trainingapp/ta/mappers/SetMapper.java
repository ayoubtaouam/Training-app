package com.trainingapp.ta.mappers;

import com.trainingapp.ta.dtos.SetDTO;
import com.trainingapp.ta.entities.Set;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component @AllArgsConstructor
public class SetMapper {
    private ModelMapper mapper;

    public Set toSet(SetDTO dto) {
        return mapper.map(dto, Set.class);
    }
    public SetDTO toDTO(Set set) {
        return mapper.map(set, SetDTO.class);
    }
}
