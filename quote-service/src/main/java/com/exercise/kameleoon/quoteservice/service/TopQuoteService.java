package com.exercise.kameleoon.quoteservice.service;

import com.exercise.kameleoon.quoteservice.model.Quote;

import java.util.List;

public interface TopQuoteService {
    List<Quote> getTop10BestQuote();
    List<Quote> getTop10WorstQuote();
}
