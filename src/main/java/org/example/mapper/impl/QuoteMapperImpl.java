package org.example.mapper.impl;

import org.example.mapper.QuoteMapper;
import org.example.model.dto.response.QuoteResponseDto;
import org.example.model.entity.Quote;
import org.springframework.stereotype.Component;

@Component
public class QuoteMapperImpl implements QuoteMapper {
    @Override
    public QuoteResponseDto map(Quote quote) {
        return QuoteResponseDto.builder()
                .date(quote.getDate())
                .text(quote.getText())
                .user(quote.getPostedBy())
                .build();
    }
}
