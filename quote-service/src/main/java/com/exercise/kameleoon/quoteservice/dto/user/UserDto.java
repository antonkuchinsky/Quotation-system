package com.exercise.kameleoon.quoteservice.dto.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record UserDto(
        @NotEmpty(message = "Username can't be empty")
        @NotNull(message="Username can't be null")
        String username,

        @NotEmpty(message = "Date can't be empty")
        LocalDateTime dateCreate
) {
}
