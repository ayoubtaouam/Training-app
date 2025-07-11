package com.trainingapp.ta.exceptions.costumExceptions;

public class MesocycleNotFoundException extends RuntimeException{
    public MesocycleNotFoundException(Long id) {
        super("Mesocycle with id " + id + " not found!");
    }
}
