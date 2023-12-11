package com.exercise.kameleoon.userservice.dto;


import java.time.LocalDate;

public record UserDto(
        String username,
        LocalDate dateCreate
) {
}
