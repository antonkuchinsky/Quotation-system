package com.exercise.kameleoon.quoteservice.service;

import com.exercise.kameleoon.quoteservice.dto.QuoteCreateDto;
import com.exercise.kameleoon.quoteservice.dto.QuoteDto;
import com.exercise.kameleoon.quoteservice.dto.QuoteUpdateDto;
import com.exercise.kameleoon.quoteservice.model.Quote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.UUID;

public interface QuoteService {
    Page<Quote> getAllQuotes(Pageable pageable);
    QuoteDto getQuoteById(UUID id);
    Quote addQuote(QuoteCreateDto quoteCreateDto);
    Quote updateQuote(QuoteUpdateDto quoteUpdateDto);
    void deleteQuote(UUID id);
}
