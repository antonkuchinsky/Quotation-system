package com.exercise.kameleoon.votingservice.controller;

import com.exercise.kameleoon.votingservice.dto.VoteDto;
import com.exercise.kameleoon.votingservice.dto.VoteResponseDto;
import com.exercise.kameleoon.votingservice.model.Vote;
import com.exercise.kameleoon.votingservice.service.QuoteService;
import com.exercise.kameleoon.votingservice.service.VoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/votes")
@RequiredArgsConstructor
public class VoteController {
    private final VoteService voteService;
    private final QuoteService quoteService;

    @GetMapping({"/{quoteId}"})
    @ResponseStatus(HttpStatus.OK)
    public List<VoteResponseDto> getVotesByQuoteId(@PathVariable UUID quoteId){
        return voteService.getVotesByQuoteId(quoteId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void voteForQuote(@RequestBody @Valid VoteDto voteDto){
        voteService.voteForQuote(voteDto);
    }

    @DeleteMapping("/{quoteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllByQuoteId(@PathVariable UUID quoteId){
        voteService.deleteAllByQuoteId(quoteId);
    }

    @GetMapping("/top/worst")
    @ResponseStatus(HttpStatus.OK)
    public List<UUID> findTop10WorstQuoteIds() {
        return quoteService.findTop10WorstQuoteIds();
    }
    
    @GetMapping("/top/best")
    @ResponseStatus(HttpStatus.OK)
    List<UUID> findTop10BestQuoteIds(){
        return quoteService.findTop10BestQuoteIds();
    }

}
