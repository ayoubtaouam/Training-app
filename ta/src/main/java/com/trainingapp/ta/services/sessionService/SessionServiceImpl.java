package com.trainingapp.ta.services.sessionService;

import com.trainingapp.ta.dtos.ReorderingExerciseDTO;
import com.trainingapp.ta.dtos.SessionDTO;
import com.trainingapp.ta.entities.Session;
import com.trainingapp.ta.entities.SessionExercise;
import com.trainingapp.ta.exceptions.costumExceptions.SessionNotFoundException;
import com.trainingapp.ta.mappers.SessionMapper;
import com.trainingapp.ta.repositories.SessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
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
    public Page<SessionDTO> getAllSessions(Pageable pageable) {
        Page<Session> sessions = sessionRepository.findAll(pageable);
        return sessions.map(s -> sessionMapper.toDTO(s));
    }

    @Override
    public void deleteSession(Long id) {
        if (!sessionRepository.existsById(id)) {
            throw new SessionNotFoundException(id);
        }
        sessionRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Session updateSession(Long id, SessionDTO sessionToUpdate) {
        Session session = sessionRepository.findById(id).orElseThrow(() -> new SessionNotFoundException(id));
        Session updatedSession = sessionMapper.toSession(sessionToUpdate);
        session.setName(updatedSession.getName());
        session.setDescription(updatedSession.getDescription());
        return sessionRepository.save(session);
    }

    @Transactional
    @Override
    public void reorderExercise(Long sessionId, List<ReorderingExerciseDTO> reorderingExerciseList) {
        Session session = sessionRepository.findById(sessionId).orElseThrow(() -> new SessionNotFoundException(sessionId));
        Map<Long, Integer> orderMap = reorderingExerciseList.stream().collect(Collectors.toMap(ReorderingExerciseDTO::id, ReorderingExerciseDTO::order));
        for (SessionExercise exercise:
             session.getExercises()) {
            if (orderMap.containsKey(exercise.getId())) {
                exercise.setOrder(orderMap.get(exercise.getId()));
            }
        }
    }
}
