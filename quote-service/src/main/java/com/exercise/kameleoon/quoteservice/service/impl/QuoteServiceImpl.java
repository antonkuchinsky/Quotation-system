package com.exercise.kameleoon.quoteservice.service.impl;

import com.exercise.kameleoon.quoteservice.client.VoteClient;
import com.exercise.kameleoon.quoteservice.dto.QuoteCreateDto;
import com.exercise.kameleoon.quoteservice.dto.QuoteDto;
import com.exercise.kameleoon.quoteservice.dto.QuoteUpdateDto;
import com.exercise.kameleoon.quoteservice.exception.InvalidDataException;
import com.exercise.kameleoon.quoteservice.mapper.QuoteCreateMapperDto;
import com.exercise.kameleoon.quoteservice.mapper.QuoteMapperDto;
import com.exercise.kameleoon.quoteservice.model.Quote;
import com.exercise.kameleoon.quoteservice.repository.QuoteRepository;
import com.exercise.kameleoon.quoteservice.service.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class QuoteServiceImpl implements QuoteService {
    private final QuoteRepository quoteRepository;
    private final QuoteMapperDto quoteMapperDto;
    private final QuoteCreateMapperDto quoteCreateMapperDto;
    private final VoteClient voteClient;

    @Override
    public Page<Quote> getAllQuotes(Pageable pageable) {
    return quoteRepository.findAll(pageable);
    }

    @Override
    public QuoteDto getRandomQuote() {
        return quoteMapperDto.apply(quoteRepository.findRandomQuote());
    }

    @Override
    public QuoteDto getQuoteById(UUID id) {
        return quoteMapperDto.apply(quoteRepository.findById(id).
                orElseThrow(()->new InvalidDataException("Quote with this id not found",
                "A quote with this id wasn't found")));
    }

    @Override
    @Transactional
    public Quote addQuote(QuoteCreateDto quoteCreateDto) {
        return quoteRepository.save(quoteCreateMapperDto.apply(quoteCreateDto));
    }

    @Override
    @Transactional
    public Quote updateQuote(QuoteUpdateDto quoteUpdateDto) {
        var quote=quoteRepository.findById(quoteUpdateDto.quoteId());
        quote.get().setUpdateDate(LocalDateTime.now());
        quote.get().setContent(quoteUpdateDto.content());
        return quote.map(quoteRepository::save)
                .orElseThrow(() ->
                        new InvalidDataException("Quote with this id not found", "A quote with this id wasn't found"));
    }

    @Override
    @Transactional
    public void deleteQuote(UUID id) {
        voteClient.deleteAllByQuoteId(id);
        quoteRepository.deleteById(id);
    }
}
