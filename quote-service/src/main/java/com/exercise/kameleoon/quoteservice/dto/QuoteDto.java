package com.exercise.kameleoon.quoteservice.dto;

import com.exercise.kameleoon.quoteservice.dto.user.UserDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record QuoteDto(
        @NotEmpty(message = "Content can't be empty")
        @NotNull(message="Content can't be null")
        @Length(max = 500)
        String content,

        @NotEmpty(message = "Date of creation can't be empty")
        @NotNull(message="Date of creation can't be null")
        LocalDateTime creationDate,

        LocalDateTime updateDate,

        @NotEmpty(message = "User can't be empty")
        @NotNull(message="User can't be null")
        UserDto userDto
) {
}
