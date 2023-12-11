package com.exercise.kameleoon.quoteservice.controller;

import com.exercise.kameleoon.quoteservice.dto.QuoteCreateDto;
import com.exercise.kameleoon.quoteservice.dto.QuoteDto;
import com.exercise.kameleoon.quoteservice.dto.QuoteUpdateDto;
import com.exercise.kameleoon.quoteservice.model.Quote;
import com.exercise.kameleoon.quoteservice.service.QuoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/quotes")
@RequiredArgsConstructor
public class QuoteController {
    private final QuoteService quoteService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public QuoteDto getQuoteById(@PathVariable("id") UUID id) {
        return quoteService.getQuoteById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Quote> getAllQuotes(@RequestParam(value = "page", defaultValue = "0") int page,
                                    @RequestParam(value = "size", defaultValue = "10") int size){
        return quoteService.getAllQuotes(PageRequest.of(page,size));
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public Quote addQuote(@RequestBody @Valid QuoteCreateDto quoteCreateDto){
        return quoteService.addQuote(quoteCreateDto);
    }

    @PatchMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Quote updateQuote(@RequestBody @Valid QuoteUpdateDto quoteUpdateDto){
        return quoteService.updateQuote(quoteUpdateDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteQuote(@PathVariable UUID id){
        quoteService.deleteQuote(id);
    }
}
