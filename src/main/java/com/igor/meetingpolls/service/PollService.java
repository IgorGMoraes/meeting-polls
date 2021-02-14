package com.igor.meetingpolls.service;

import com.igor.meetingpolls.model.Poll;

import java.util.List;
import java.util.Optional;

public interface PollService {
    void openPollForVote(String pollId, Optional<Integer> minutes);

    Poll save(Poll poll);

    List<Poll> findAll();
}
