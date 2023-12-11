package com.exercise.kameleoon.votingservice.controller;

import com.exercise.kameleoon.votingservice.dto.VoteDto;
import com.exercise.kameleoon.votingservice.model.Vote;
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

    @GetMapping({"quoteId"})
    @ResponseStatus(HttpStatus.OK)
    public List<Vote> getVotesByQuoteId(@PathVariable UUID quoteId){
        return voteService.getVotesByQuoteId(quoteId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void voteForQuote(@RequestBody @Valid VoteDto voteDto){
        voteService.voteForQuote(voteDto);
    }
}
