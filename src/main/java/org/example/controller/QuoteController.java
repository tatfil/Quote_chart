package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.example.model.dto.request.QuoteRequestDto;
import org.example.model.dto.response.QuoteResponseDto;
import org.example.service.QuoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/quotes")
@RequiredArgsConstructor
public class QuoteController {

    private final QuoteService quoteService;
    @Operation(summary = "Create new quote")
    @ApiResponse(responseCode = "200", description = "The order was created successfully")
    @ApiResponse(responseCode = "403", description = "Your role doesn't have access")
    @ApiResponse(responseCode = "400", description = "Incorrect data transmitted")
    @PostMapping("/")
    public ResponseEntity<QuoteResponseDto> addQuote(@Valid @RequestBody QuoteRequestDto
                                                                              quoteRequestDto) {
        QuoteResponseDto quoteResponseDto = quoteService.save(quoteRequestDto);
        return ResponseEntity.ok().body(quoteResponseDto);
    }

    @Operation(summary = "Delete order by orderId")
    @DeleteMapping("/{quoteId}")
    public ResponseEntity<Void> deleteQuoteById(@PathVariable("quoteId")UUID id) {
        quoteService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Update order")
    @PutMapping("/{quoteId}")
    public ResponseEntity<QuoteResponseDto> updateQuote(@PathVariable("quoteId")UUID id, @Valid @RequestBody QuoteRequestDto quoteRequestDto) {
        QuoteResponseDto quoteResponseDto = quoteService.updateRequest(id, quoteRequestDto);
        return ResponseEntity.ok().body(quoteResponseDto);
    }

    @Operation(summary = "Get random quote")
    @GetMapping("/randomQuote")
    public QuoteResponseDto getRandom( ){
        return quoteService.getRandomQuote();
    }

    @Operation(summary = "Get top 10 quotes")
    @GetMapping("/topQuotes")
    public List<QuoteResponseDto> getTop10Quotes(){
        return quoteService.getTop10Quotes();
    }

    @Operation(summary = "Get worst 10 quotes")
    @GetMapping("/worstQuotes")
    public List<QuoteResponseDto> getWorst10Quotes(){
        return quoteService.getWorst10Quotes();
    }

    @Operation(summary = "Get quote details")
    @GetMapping("/{id}")
    public QuoteResponseDto getQuoteById(@PathVariable(value = "quoteId") UUID id){
        return quoteService.getQuoteByID(id);
    }

}
