package org.example.mapper;

import org.example.model.dto.response.QuoteResponseDto;
import org.example.model.entity.Quote;


public interface QuoteMapper {
    QuoteResponseDto map(Quote quote);
}
