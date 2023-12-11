package com.exercise.kameleoon.votingservice.service.impl;

import com.exercise.kameleoon.votingservice.dto.VoteDto;
import com.exercise.kameleoon.votingservice.exception.InvalidDataException;
import com.exercise.kameleoon.votingservice.mapper.VoteMapperDto;
import com.exercise.kameleoon.votingservice.model.Vote;
import com.exercise.kameleoon.votingservice.repository.VoteRepository;
import com.exercise.kameleoon.votingservice.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteService {
    private final VoteRepository voteRepository;
    private final VoteMapperDto voteMapperDto;

    @Override
    public List<Vote> getVotesByQuoteId(UUID id) {
        return voteRepository.getAllByQuoteId(id)
                .orElseThrow(()->new InvalidDataException("Votes with this quote id not found",
                "Votes with this quote id wasn't found"));
    }

    @Override
    public void voteForQuote(VoteDto voteDto) {
        var vote= voteRepository.findByQuoteIdAndUsername(voteDto.quoteId(),voteDto.username());
        if(vote.isPresent()){
            vote.get().setInFavor(voteDto.inFavor());
            voteRepository.save(vote.get());
        }
        else{
            voteRepository.save(voteMapperDto.apply(voteDto));
        }
    }
}
