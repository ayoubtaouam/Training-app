package com.trainingapp.ta.services.sessionService;

import com.trainingapp.ta.dtos.ReorderingExerciseDTO;
import com.trainingapp.ta.dtos.SessionDTO;
import com.trainingapp.ta.entities.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SessionService {
    Session addSession(SessionDTO session);
    SessionDTO getSession(Long id);
    Page<SessionDTO> getAllSessions(Pageable pageable);
    void deleteSession(Long id);
    Session updateSession(Long id, SessionDTO sessionToUpdate);
    void reorderExercise(Long sessionId, List<ReorderingExerciseDTO> reorderingExerciseList);
}
