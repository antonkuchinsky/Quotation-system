package com.exercise.kameleoon.quoteservice.dto.vote;

public record VoteResponseDto(
        String username,
        boolean inFavor
) {
}