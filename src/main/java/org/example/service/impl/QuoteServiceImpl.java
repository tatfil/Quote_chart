package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.exception.StorageDataAlreadyExistsException;
import org.example.exception.StorageDataNotFoundException;
import org.example.mapper.QuoteMapper;
import org.example.model.dto.request.QuoteRequestDto;
import org.example.model.dto.response.QuoteResponseDto;
import org.example.model.entity.Quote;
import org.example.repository.QuoteRepository;
import org.example.service.QuoteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuoteServiceImpl implements QuoteService {

    private final QuoteRepository quoteRepository;

    private final QuoteMapper quoteMapper;

    private static final int INIT_RATING = 0;

    @Override
    @Transactional
    public QuoteResponseDto save(QuoteRequestDto dto) {
        Optional<Quote> quoteOptional = quoteRepository.findByText(dto.getText());

        if (quoteOptional.isPresent()) {
            throw new StorageDataAlreadyExistsException("Such quote already exists.");
        }
        else{
            Quote quote = quoteRepository.save(Quote.builder()
                    .postedBy(dto.getPostedBy())
                    .text(dto.getText())
                    .date(LocalDate.now())
                    .rating(INIT_RATING)
                    .build());

            return quoteMapper.map(quote);
        }
    }

    @Override
    public Quote findById(UUID id) {
        return quoteRepository.findById(id).orElseThrow(() ->
                new StorageDataNotFoundException("Quote not found"));
    }

    @Override
    @Transactional
    public QuoteResponseDto updateRequest(UUID id, QuoteRequestDto quoteRequestDto) {

        Optional<Quote> quoteOptional = quoteRepository.findById(id);
        if(quoteOptional.isPresent()){
            quoteOptional.orElseThrow().setText(quoteRequestDto.getText());
            quoteOptional.orElseThrow().setPostedBy(quoteRequestDto.getPostedBy());
            return quoteMapper.map(quoteRepository.save(quoteOptional.get()));
        }
        else
            throw new StorageDataNotFoundException("Quote not found");
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        Optional<Quote> quoteOptional = quoteRepository.findById(id);
        if(quoteOptional.isPresent()){
            quoteRepository.deleteById(id);
        }
        else
            throw new StorageDataNotFoundException("Quote not found");
    }

    @Override
    public QuoteResponseDto getRandomQuote() {
        Quote quote = quoteRepository.getRandomQuote();
        return quoteMapper.map(quote);

    }

    @Override
    public List<QuoteResponseDto> getTop10Quotes() {
        List<Quote> quoteList = quoteRepository.getTop10Quotes();
        return quoteList.stream().map(quote -> quoteMapper.map(quote)).collect(Collectors.toList());
    }

    @Override
    public List<QuoteResponseDto> getWorst10Quotes() {
        List<Quote> quoteList = quoteRepository.getWorst10Quotes();
        return quoteList.stream().map(quote -> quoteMapper.map(quote)).collect(Collectors.toList());
    }

    @Override
    public QuoteResponseDto getQuoteByID(UUID id) {
        Optional<Quote> quote = quoteRepository.findById(id);
        if (quote.isPresent())
            return quoteMapper.map(quote.get());
        else
            throw new StorageDataNotFoundException("Quote not found");
    }

    @Override
    @Transactional
    public void updateRating(UUID quoteId, boolean upvote) {
        Optional<Quote> quoteOptional = quoteRepository.findById(quoteId);
        if(quoteOptional.isPresent()){
            Quote quote = quoteOptional.get();
            Integer rating = quote.getRating();
            if(upvote)
                rating++;
            else
                rating--;
            quoteRepository.updateRating(rating, quoteId);
        }
        else
            throw new StorageDataNotFoundException("Quote not found");
    }
}
