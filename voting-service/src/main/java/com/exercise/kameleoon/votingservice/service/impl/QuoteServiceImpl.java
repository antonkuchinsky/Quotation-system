package com.exercise.kameleoon.votingservice.service.impl;

import com.exercise.kameleoon.votingservice.repository.VoteRepository;
import com.exercise.kameleoon.votingservice.service.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class QuoteServiceImpl implements QuoteService {
    private final VoteRepository voteRepository;

    @Override
    public List<UUID> findTop10WorstQuoteIds() {
        return voteRepository.findTop10WorstQuoteIds();
    }

    @Override
    public List<UUID> findTop10BestQuoteIds() {
        return voteRepository.findTop10BestQuoteIds();
    }
}
