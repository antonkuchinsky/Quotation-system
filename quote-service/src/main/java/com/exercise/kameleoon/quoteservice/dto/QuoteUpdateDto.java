package com.exercise.kameleoon.quoteservice.dto;

import java.util.UUID;

public record QuoteUpdateDto(
        UUID quoteId,
        String content
) {
}
