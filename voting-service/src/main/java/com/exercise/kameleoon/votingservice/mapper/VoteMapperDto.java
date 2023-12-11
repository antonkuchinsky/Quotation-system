package com.exercise.kameleoon.votingservice.mapper;

import com.exercise.kameleoon.votingservice.dto.VoteDto;
import com.exercise.kameleoon.votingservice.model.Vote;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class VoteMapperDto implements Function<VoteDto, Vote> {
    @Override
    public Vote apply(VoteDto voteDto) {
        return Vote.builder()
                .username(voteDto.username())
                .quoteId(voteDto.quoteId())
                .inFavor(voteDto.inFavor())
                .build();
    }
}
