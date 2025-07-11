package com.trainingapp.ta.exceptions.costumExceptions;

public class MicrocycleNotFoundException extends RuntimeException{
    public MicrocycleNotFoundException(Long id) {
        super("Microcycle with id " + id + " not found.");
    }
}
