package com.trainingapp.ta.mappers;

import com.trainingapp.ta.dtos.SessionDTO;
import com.trainingapp.ta.entities.Session;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component @AllArgsConstructor
public class SessionMapper {
    private ModelMapper mapper;

    public Session toSession(SessionDTO dto) {
        return mapper.map(dto, Session.class);
    }
    public SessionDTO toDTO(Session session) {
        return mapper.map(session, SessionDTO.class);
    }
}
