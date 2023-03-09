package org.example.service;

import org.example.model.dto.request.QuoteRequestDto;
import org.example.model.dto.response.QuoteResponseDto;
import org.example.model.entity.Quote;

import java.util.List;
import java.util.UUID;

public interface QuoteService {
    QuoteResponseDto save(QuoteRequestDto dto);
    Quote findById(UUID id);

    QuoteResponseDto updateRequest(UUID id, QuoteRequestDto quoteRequestDto);
    void deleteById(UUID id);

    QuoteResponseDto getRandomQuote();

    List<QuoteResponseDto> getTop10Quotes();

    List<QuoteResponseDto> getWorst10Quotes();

    QuoteResponseDto getQuoteByID(UUID id);

    void updateRating(UUID quoteId, boolean upvote);

}
