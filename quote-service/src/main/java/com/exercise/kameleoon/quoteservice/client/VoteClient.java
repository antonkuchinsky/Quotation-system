package com.exercise.kameleoon.quoteservice.client;

import com.exercise.kameleoon.quoteservice.dto.vote.VoteResponseDto;
import com.exercise.kameleoon.quoteservice.model.vote.Vote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "voting-service")
public interface VoteClient {

    @GetMapping("/api/v1/votes/{quoteId}")
    List<VoteResponseDto> getVotesByQuoteId(@PathVariable("quoteId") UUID quoteId);

    @DeleteMapping("/api/v1/votes/{quoteId}")
    void deleteAllByQuoteId(@PathVariable("quoteId") UUID quoteId);

    @GetMapping("/api/v1/votes/top/worst")
    List<UUID> findTop10WorstQuoteIds();

    @GetMapping("/api/v1/votes/top/best")
    List<UUID> findTop10BestQuoteIds();
}