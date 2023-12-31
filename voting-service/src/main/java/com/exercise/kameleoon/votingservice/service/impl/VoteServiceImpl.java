package com.exercise.kameleoon.votingservice.service.impl;

import com.exercise.kameleoon.votingservice.dto.VoteDto;
import com.exercise.kameleoon.votingservice.dto.VoteResponseDto;
import com.exercise.kameleoon.votingservice.exception.InvalidDataException;
import com.exercise.kameleoon.votingservice.mapper.VoteMapperDto;
import com.exercise.kameleoon.votingservice.mapper.VoteResponseMapperDto;
import com.exercise.kameleoon.votingservice.model.Vote;
import com.exercise.kameleoon.votingservice.repository.VoteRepository;
import com.exercise.kameleoon.votingservice.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteService {
    private final VoteRepository voteRepository;
    private final VoteMapperDto voteMapperDto;
    private final VoteResponseMapperDto voteResponseMapperDto;

    @Override
    public List<VoteResponseDto> getVotesByQuoteId(UUID id) {
        List<Vote> votes = voteRepository.getAllByQuoteId(id)
                .orElseThrow(() -> new InvalidDataException("Votes with this quote id not found",
                        "Votes with this quote id wasn't found"));

        return voteResponseMapperDto.apply(votes);
    }

    @Override
    @Transactional
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

    @Override
    @Transactional
    public void deleteAllByQuoteId(UUID quoteId) {
        voteRepository.deleteAllByQuoteId(quoteId);
    }
}
