package com.exercise.kameleoon.votingservice.repository;

import com.exercise.kameleoon.votingservice.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface VoteRepository extends JpaRepository<Vote, UUID> {
    Optional<List<Vote>> getAllByQuoteId(UUID quoteId);
    Optional<Vote> findByQuoteIdAndUsername(UUID quoteId, String username);
    void deleteAllByQuoteId(UUID quoteId);
}
