package com.exercise.kameleoon.quoteservice.repository;

import com.exercise.kameleoon.quoteservice.model.Quote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, UUID> {
    @Query(value = "SELECT * FROM quotes ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Quote findRandomQuote();
    Page<Quote> findAll(Pageable pageable);
    Optional<Quote> findById(UUID id);
    void deleteById(UUID id);
}
