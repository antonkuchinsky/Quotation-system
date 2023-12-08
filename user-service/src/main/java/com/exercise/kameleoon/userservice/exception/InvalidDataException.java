package com.exercise.kameleoon.userservice.exception;

public class InvalidDataException extends RuntimeException{
    private final String title;
    public InvalidDataException(String message, String title) {
        super(message);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
