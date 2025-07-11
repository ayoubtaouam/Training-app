package com.trainingapp.ta.exceptions.costumExceptions;

public class SetNotFoundException extends RuntimeException{
    public SetNotFoundException(Long id) {
        super("Set with id " + id + " not found.");
    }
}
