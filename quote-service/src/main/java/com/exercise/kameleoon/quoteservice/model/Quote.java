package com.exercise.kameleoon.quoteservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="quotes")
@Data
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String content;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
    private UUID userId;

}