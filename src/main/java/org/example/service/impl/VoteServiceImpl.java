package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.model.dto.request.VoteRequestDto;
import org.example.model.entity.User;
import org.example.model.entity.Vote;
import org.example.repository.QuoteRepository;
import org.example.service.QuoteService;
import org.example.service.UserService;
import org.example.service.VoteService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteService {

    private final UserService userService;

    private final QuoteService quoteService;

    private final QuoteRepository quoteRepository;

    @Override
    public void vote(VoteRequestDto voteRequestDto, boolean upvote) {
        User user = userService.findById(voteRequestDto.getUser_id()).orElseThrow();
        quoteService.updateRating(voteRequestDto.getQuote_id(), upvote);
    }


}
