package org.example.controller;


import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.model.dto.request.VoteRequestDto;
import org.example.service.VoteService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    VoteService voteService;


    @Operation(summary = "Upvote the quote")
    @PutMapping("/{quoteId}/upvote")
    public void upvote(@RequestBody VoteRequestDto voteRequestDto) {
        voteService.vote(voteRequestDto, true);
    }

    @Operation(summary = "Downvote the quote")
    @PutMapping("/{quoteId}/downvote")
    public void downvote(@RequestBody VoteRequestDto voteRequestDto) {
        voteService.vote(voteRequestDto, false);
    }
}
