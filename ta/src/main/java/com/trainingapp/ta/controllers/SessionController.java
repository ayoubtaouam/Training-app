package com.trainingapp.ta.controllers;

import com.trainingapp.ta.dtos.ReorderingExerciseDTO;
import com.trainingapp.ta.dtos.SessionDTO;
import com.trainingapp.ta.entities.Session;
import com.trainingapp.ta.services.sessionService.SessionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @AllArgsConstructor
@RequestMapping("sessions")
public class SessionController {
    private SessionService sessionService;

    @GetMapping
    public Page<SessionDTO> getAllSessions(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "10") int size) {
        return sessionService.getAllSessions(PageRequest.of(page, size));
    }
    @GetMapping("{id}")
    public SessionDTO getSession(@PathVariable Long id) {
        return sessionService.getSession(id);
    }
    @PostMapping
    public ResponseEntity<Session> addSession(@RequestBody @Valid SessionDTO session) {
        return ResponseEntity.status(201).body(sessionService.addSession(session));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSession(@PathVariable Long id) {
        sessionService.deleteSession(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}")
    public Session updateSession(@PathVariable Long id, @RequestBody SessionDTO updatedSession) {
        return sessionService.updateSession(id, updatedSession);
    }
    @PatchMapping("{sessionId}/reorder")
    public ResponseEntity<Void> reorderExercises(@PathVariable Long sessionId, @RequestBody List<ReorderingExerciseDTO> reorderingList) {
        sessionService.reorderExercise(sessionId, reorderingList);
        return ResponseEntity.noContent().build();
    }
}
