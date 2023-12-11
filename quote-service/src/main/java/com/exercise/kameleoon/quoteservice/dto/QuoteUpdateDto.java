package com.exercise.kameleoon.quoteservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

public record QuoteUpdateDto(
        @NotNull(message="Id can't be null")
        UUID quoteId,

        @NotEmpty(message = "Content can't be empty")
        @NotNull(message="Content can't be null")
        @Length(max = 500)
        String content
) {
}
