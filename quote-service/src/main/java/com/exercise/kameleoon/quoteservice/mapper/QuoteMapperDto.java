package com.exercise.kameleoon.quoteservice.mapper;

import com.exercise.kameleoon.quoteservice.client.UserClient;
import com.exercise.kameleoon.quoteservice.client.VoteClient;
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
    private final VoteClient voteClient;
    @Override
    public QuoteDto apply(Quote quote) {
        var userDto = userClient.getUserByUsername(quote.getUsername()).get();
        var votes = voteClient.getVotesByQuoteId(quote.getId());
        return new QuoteDto(quote.getContent(),
                quote.getCreationDate(),
                quote.getUpdateDate(),
                userDto,
                votes);
    }
}
