package com.trainingapp.ta.controllers;

import com.trainingapp.ta.dtos.ReorderingExerciseDTO;
import com.trainingapp.ta.services.sessionService.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @AllArgsConstructor
public class SessionController {
    private SessionService sessionService;

    @PatchMapping("{sessionId}/reorder")
    public ResponseEntity<Void> reorderExercises(@PathVariable Long sessionId, @RequestBody List<ReorderingExerciseDTO> reorderingList) {
        sessionService.reorderExercise(sessionId, reorderingList);
        return ResponseEntity.noContent().build();
    }
}
