package com.exercise.kameleoon.votingservice.dto;

public record VoteResponseDto(
        String username,
        boolean inFavor
) {
}
