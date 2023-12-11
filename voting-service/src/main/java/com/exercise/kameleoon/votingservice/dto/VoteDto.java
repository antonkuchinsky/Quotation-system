package com.exercise.kameleoon.votingservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record VoteDto(
        @NotEmpty(message = "Quote id can't be empty")
        @NotNull(message="Quote id can't be null")
        UUID quoteId,

        @NotEmpty(message = "Username can't be empty")
        @NotNull(message="Username can't be null")
        String username,

        @NotEmpty(message = "Boolean value can't be empty")
        @NotNull(message="Boolean value can't be null")
        boolean inFavor
) {
}
