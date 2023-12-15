package com.exercise.kameleoon.quoteservice.mapper;

import com.exercise.kameleoon.quoteservice.client.UserClient;
import com.exercise.kameleoon.quoteservice.client.VoteClient;
import com.exercise.kameleoon.quoteservice.dto.QuoteDto;
import com.exercise.kameleoon.quoteservice.dto.user.UserDto;
import com.exercise.kameleoon.quoteservice.dto.vote.VoteResponseDto;
import com.exercise.kameleoon.quoteservice.model.Quote;
import com.exercise.kameleoon.quoteservice.model.vote.Vote;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class QuoteMapperDto implements Function<Quote, QuoteDto> {
    private final UserClient userClient;
    private final VoteClient voteClient;

    @Override
    public QuoteDto apply(Quote quote) {
        UserDto userDto;
        List<VoteResponseDto> votes;

        try {
            userDto = userClient.getUserByUsername(quote.getUsername()).get();
        } catch (Exception e) {
            userDto = new UserDto(quote.getUsername(), null);
        }

        try {
            votes = voteClient.getVotesByQuoteId(quote.getId());
        } catch (Exception e) {
            votes = null;
        }

        return new QuoteDto(quote.getContent(),
                quote.getCreationDate(),
                quote.getUpdateDate(),
                userDto,
                votes);
    }
}
