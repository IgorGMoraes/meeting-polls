package com.igor.meetingpolls.service;

import com.igor.meetingpolls.model.Vote;
import com.igor.meetingpolls.model.VoteRequest;

public interface VoteService {

    Vote createVote(String pollId, VoteRequest voteRequest);
}
