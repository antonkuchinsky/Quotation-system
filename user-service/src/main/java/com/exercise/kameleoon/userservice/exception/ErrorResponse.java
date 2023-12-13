package com.exercise.kameleoon.userservice.exception;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class ErrorResponse {
    private String title;
    private String message;
    private ZonedDateTime dateTimeError;
}
