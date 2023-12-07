package com.exercise.kameleoon.userservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotEmpty(message = "Username can't be empty")
    @NotNull(message = "User name is not null")
    @Pattern(message = "Bad formed person username: ${validatedValue}",
            regexp = "^[a-z A-Zа-яA-Я0-9_-]{2,255}$")
    @Length(min = 2, max = 255, message = "The length of the name must be from 2 to 255 characters")
    private String username;

    @NotEmpty(message = "Email can't be empty")
    @NotNull(message="Email can't be null")
    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;

    @NotEmpty(message = "Password can't be empty")
    @NotNull(message="Password can't be null")
    private String password;

    @NotEmpty(message = "Date can't be empty")
    @NotNull(message="Date can't be null")
    private LocalDateTime dateCreate;

}
