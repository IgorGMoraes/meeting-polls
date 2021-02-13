package com.igor.meetingpolls.controller.v1;

import com.igor.meetingpolls.model.Vote;
import com.igor.meetingpolls.model.VoteRequest;
import com.igor.meetingpolls.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/vote")
@RequiredArgsConstructor
public class VoteController {

    private final VoteService voteService;

    @PostMapping("/{pollId}")
    public Vote crateVote(@PathVariable String pollId,
                          @RequestBody VoteRequest voteRequest){
        return voteService.createVote(pollId, voteRequest);
    }

}
