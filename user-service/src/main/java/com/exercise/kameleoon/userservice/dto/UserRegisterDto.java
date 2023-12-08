package com.exercise.kameleoon.userservice.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;



public record UserRegisterDto(
        @NotEmpty(message = "Email can't be empty")
        @NotNull(message="Email can't be null")
        @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
        String email,

        @NotEmpty(message = "Username can't be empty")
        @NotNull(message = "User name is not null")
        @Pattern(message = "Bad formed person username: ${validatedValue}",
                regexp = "^[a-z A-Zа-яA-Я0-9_-]{2,255}$")
        @Length(min = 2, max = 255, message = "The length of the name must be from 2 to 255 characters")
        String username,

        @NotEmpty(message = "Password can't be empty")
        @NotNull(message="Password can't be null")
        String password
) {
}
