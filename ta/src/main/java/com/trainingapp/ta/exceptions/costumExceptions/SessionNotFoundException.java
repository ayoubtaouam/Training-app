package com.trainingapp.ta.exceptions.costumExceptions;

public class SessionNotFoundException extends RuntimeException{
    public SessionNotFoundException(Long id) {
        super("Session with id " + id + " not found.");
    }
}
