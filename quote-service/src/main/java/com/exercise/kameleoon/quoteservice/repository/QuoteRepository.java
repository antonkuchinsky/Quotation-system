package com.exercise.kameleoon.quoteservice.repository;

import com.exercise.kameleoon.quoteservice.model.Quote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;
import java.util.UUID;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, UUID> {
    Page<Quote> findAll(Pageable pageable);
    Optional<Quote> findById(UUID id);
    void deleteById(Long id);
}
