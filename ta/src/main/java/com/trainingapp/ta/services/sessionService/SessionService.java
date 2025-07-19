package com.trainingapp.ta.services.sessionService;

import com.trainingapp.ta.dtos.ReorderingExerciseDTO;
import com.trainingapp.ta.dtos.SessionDTO;
import com.trainingapp.ta.entities.Session;

import java.util.List;

public interface SessionService {
    Session addSession(SessionDTO session);
    SessionDTO getSession(Long id);
    List<SessionDTO> getAllSessions(Long id);
    void deleteSession(Long id);
    Session updateSession(Long id, SessionDTO sessionToUpdate);
    void reorderExercise(Long sessionId, List<ReorderingExerciseDTO> reorderingExerciseList);
}
