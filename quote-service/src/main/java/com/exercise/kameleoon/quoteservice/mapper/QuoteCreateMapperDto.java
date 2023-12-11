package com.exercise.kameleoon.quoteservice.mapper;

import com.exercise.kameleoon.quoteservice.dto.QuoteCreateDto;
import com.exercise.kameleoon.quoteservice.model.Quote;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.function.Function;

@Service
public class QuoteCreateMapperDto implements Function<QuoteCreateDto, Quote> {
    @Override
    public Quote apply(QuoteCreateDto quoteCreateDto) {
        return Quote.builder()
                .creationDate(LocalDateTime.now())
                .content(quoteCreateDto.content())
                .username(quoteCreateDto.username())
                .build();
    }
}
