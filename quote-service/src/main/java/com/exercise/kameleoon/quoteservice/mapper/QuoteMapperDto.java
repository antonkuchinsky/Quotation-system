package com.exercise.kameleoon.quoteservice.mapper;

import com.exercise.kameleoon.quoteservice.client.UserClient;
import com.exercise.kameleoon.quoteservice.dto.QuoteDto;
import com.exercise.kameleoon.quoteservice.dto.user.UserDto;
import com.exercise.kameleoon.quoteservice.model.Quote;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class QuoteMapperDto implements Function<Quote, QuoteDto> {
    private final UserClient userClient;
    @Override
    public QuoteDto apply(Quote quote) {
        try {
            var userDto = userClient.getUserByUsername(quote.getUsername()).get();
            return new QuoteDto(quote.getContent(), quote.getCreationDate(), quote.getUpdateDate(), userDto);
        } catch (Exception e) {
            return new QuoteDto(quote.getContent(), quote.getCreationDate(), quote.getUpdateDate(), new UserDto(quote.getUsername(),null));
        }
    }
}
