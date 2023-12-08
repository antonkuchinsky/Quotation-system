package com.exercise.kameleoon.quoteservice.repository;

import com.exercise.kameleoon.quoteservice.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface QuoteRepository extends JpaRepository<UUID, Quote> {
}
