package com.igor.meetingpolls.service;

import java.util.Optional;

public interface PollService {
    void openPollForVotation(String pollId, Optional<Integer> minutes);
}
