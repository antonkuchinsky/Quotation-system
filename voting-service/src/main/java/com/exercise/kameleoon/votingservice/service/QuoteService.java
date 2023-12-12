package com.exercise.kameleoon.votingservice.service;

import java.util.List;
import java.util.UUID;

public interface QuoteService {
    List<UUID> findTop10WorstQuoteIds();
    List<UUID> findTop10BestQuoteIds();
}
