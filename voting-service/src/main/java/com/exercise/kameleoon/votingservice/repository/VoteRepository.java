package com.exercise.kameleoon.votingservice.repository;

import com.exercise.kameleoon.votingservice.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface VoteRepository extends JpaRepository<Vote, UUID> {
    @Query("SELECT v.quoteId " +
            "FROM Vote v " +
            "WHERE v.inFavor = true " +
            "GROUP BY v.quoteId " +
            "ORDER BY COUNT(v) DESC")
    List<UUID> findTop10BestQuoteIds();

    @Query("SELECT v.quoteId " +
            "FROM Vote v " +
            "WHERE v.inFavor = false " +
            "GROUP BY v.quoteId " +
            "ORDER BY COUNT(v) DESC")
    List<UUID> findTop10WorstQuoteIds();

    Optional<List<Vote>> getAllByQuoteId(UUID quoteId);

    Optional<Vote> findByQuoteIdAndUsername(UUID quoteId, String username);

    void deleteAllByQuoteId(UUID quoteId);
}
