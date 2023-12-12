package com.exercise.kameleoon.votingservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record VoteDto(
        @NotNull(message="Quote id can't be null")
        UUID quoteId,

        @NotEmpty(message = "Username can't be empty")
        @NotNull(message="Username can't be null")
        String username,

        @NotNull(message="Boolean value can't be null")
        Boolean inFavor
) {
}
