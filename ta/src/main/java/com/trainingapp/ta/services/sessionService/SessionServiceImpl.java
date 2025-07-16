package com.trainingapp.ta.services.sessionService;

import com.trainingapp.ta.dtos.SessionDTO;
import com.trainingapp.ta.entities.Session;
import com.trainingapp.ta.exceptions.costumExceptions.SessionNotFoundException;
import com.trainingapp.ta.mappers.SessionMapper;
import com.trainingapp.ta.repositories.SessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service @AllArgsConstructor
public class SessionServiceImpl implements SessionService {
    private SessionRepository sessionRepository;
    private SessionMapper sessionMapper;
    @Override
    public Session addSession(SessionDTO session) {
        return sessionRepository.save(sessionMapper.toSession(session));
    }

    @Override
    public SessionDTO getSession(Long id) {
        Session session = sessionRepository.findById(id).orElseThrow(() -> new SessionNotFoundException(id));
        return sessionMapper.toDTO(session);
    }

    @Override
    public List<SessionDTO> getAllSessions(Long id) {
        List<Session> sessions = sessionRepository.findAll();
        return sessions.stream().map(s -> sessionMapper.toDTO(s)).collect(Collectors.toList());
    }

    @Override
    public void deleteSession(Long id) {
        Session session = sessionRepository.findById(id).orElseThrow(() -> new SessionNotFoundException(id));
        sessionRepository.deleteById(id);
    }

    @Override
    public Session updateSession(Long id, SessionDTO sessionToUpdate) {
        Session session = sessionRepository.findById(id).orElseThrow(() -> new SessionNotFoundException(id));
        session.setName(sessionMapper.toSession(sessionToUpdate).getName());
        session.setDescription((sessionMapper.toSession(sessionToUpdate)).getDescription());
        return sessionRepository.save(session);
    }
}
