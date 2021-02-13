package com.igor.meetingpolls.service.consumer;

import com.igor.meetingpolls.constants.Constants;
import com.igor.meetingpolls.exception.ResourceNotFoundException;
import com.igor.meetingpolls.model.Poll;
import com.igor.meetingpolls.model.Vote;
import com.igor.meetingpolls.repository.PollRepository;
import com.igor.meetingpolls.repository.VoteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class VoteConsumer {

    private final VoteRepository voteRepository;
    private final PollRepository pollRepository;

    @RabbitListener(queues = Constants.QUEUE)
    public void calculateResultAndSaveVoteFromQueue(Vote vote){
        log.info("Saving vote with id {} to poll with id {}", vote.getId(), vote.getPollId());
        Poll poll = pollRepository.findById(vote.getPollId())
                .orElseThrow(() -> new ResourceNotFoundException("Poll doesn't exist."));
        poll.addVote(vote);
        poll.setResult(calculateResultFromNewVote(vote, poll.getResult()));
        pollRepository.save(poll);
    }

    //Update the result as the votes are accounted
    private int calculateResultFromNewVote(Vote vote, int result) {
        return vote.isChoice() ? result + 1 : result - 1;
    }
}
