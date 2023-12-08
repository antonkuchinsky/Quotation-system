package com.exercise.kameleoon.quoteservice.service;

import com.exercise.kameleoon.quoteservice.dto.QuoteCreateDto;
import com.exercise.kameleoon.quoteservice.dto.QuoteUpdateDto;
import com.exercise.kameleoon.quoteservice.model.Quote;

import java.util.List;
import java.util.UUID;

public interface QuoteService {
    List<Quote> getAllQuotes();
    Quote getQuoteById(UUID id);
    Quote addQuote(QuoteCreateDto quoteCreateDto);
    Quote updateQuote(QuoteUpdateDto quoteUpdateDto);
    void deleteQuote(UUID id);
}
