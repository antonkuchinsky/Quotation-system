package com.exercise.kameleoon.quoteservice.dto;


import java.util.UUID;

public record QuoteCreateDto(
        UUID userId,
        String content
) {
}
