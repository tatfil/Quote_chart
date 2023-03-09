package org.example.service;

import org.example.model.dto.request.VoteRequestDto;

public interface VoteService {
    void vote(VoteRequestDto voteRequestDto, boolean upvote);
}
