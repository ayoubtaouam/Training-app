package com.trainingapp.ta.exceptions.costumExceptions;

public class SessionExerciseNotFoundException extends RuntimeException{
    public SessionExerciseNotFoundException(Long id) {
        super("Exercise with id " + id + " not found.");
    }
}
