package com.exercise.kameleoon.quoteservice.service.impl;

import com.exercise.kameleoon.quoteservice.client.VoteClient;
import com.exercise.kameleoon.quoteservice.model.Quote;
import com.exercise.kameleoon.quoteservice.repository.QuoteRepository;
import com.exercise.kameleoon.quoteservice.service.TopQuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopQuoteServiceImpl implements TopQuoteService {
    private final VoteClient voteClient;
    private final QuoteRepository quoteRepository;

    @Override
    @Transactional
    public List<Quote> getTop10BestQuote() {
        var quotesId=voteClient.findTop10BestQuoteIds();
        return quoteRepository.findAllById(quotesId);
    }

    @Override
    @Transactional
    public List<Quote> getTop10WorstQuote() {
        var quotesId=voteClient.findTop10WorstQuoteIds();
        return quoteRepository.findAllById(quotesId);
    }
}
