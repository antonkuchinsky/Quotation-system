package com.exercise.kameleoon.votingservice.service;


import com.exercise.kameleoon.votingservice.dto.VoteDto;
import com.exercise.kameleoon.votingservice.dto.VoteResponseDto;

import java.util.List;
import java.util.UUID;

public interface VoteService {
    List<VoteResponseDto> getVotesByQuoteId(UUID id);
    void voteForQuote(VoteDto voteDto);
    void deleteAllByQuoteId(UUID quoteId);
}
