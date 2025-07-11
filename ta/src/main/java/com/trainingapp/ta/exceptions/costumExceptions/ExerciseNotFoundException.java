package com.trainingapp.ta.exceptions.costumExceptions;

public class ExerciseNotFoundException extends RuntimeException{
    public ExerciseNotFoundException(Long id) {
        super("Exercise with id " + id + " not found.");
    }
}
