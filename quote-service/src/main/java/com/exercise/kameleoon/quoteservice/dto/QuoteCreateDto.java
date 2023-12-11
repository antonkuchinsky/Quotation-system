package com.exercise.kameleoon.quoteservice.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;


public record QuoteCreateDto(
        @NotEmpty(message = "Username can't be empty")
        @NotNull(message="Username can't be null")
        String username,

        @NotEmpty(message = "Content can't be empty")
        @NotNull(message="Content can't be null")
        @Length(max = 500)
        String content
) {
}
