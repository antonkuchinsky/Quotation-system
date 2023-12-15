package com.exercise.kameleoon.votingservice.mapper;

import com.exercise.kameleoon.votingservice.dto.VoteResponseDto;
import com.exercise.kameleoon.votingservice.model.Vote;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class VoteResponseMapperDto implements Function<List<Vote>, List<VoteResponseDto>> {
    @Override
    public List<VoteResponseDto> apply(List<Vote> votes) {
        return votes.stream()
                .map(this::mapToVoteResponseDto)
                .collect(Collectors.toList());
    }

    private VoteResponseDto mapToVoteResponseDto(Vote vote) {
        return new VoteResponseDto(vote.getUsername(), vote.isInFavor());
    }
}
