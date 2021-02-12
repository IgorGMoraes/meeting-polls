package com.igor.meetingpolls.service.consumer;

import com.igor.meetingpolls.constants.Constants;
import com.igor.meetingpolls.model.Vote;
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

    @RabbitListener(queues = Constants.QUEUE)
    public void saveVoteFromQueue(Vote vote){
        log.debug("Saving vote with id {} to poll with id {}", vote.getId(), vote.getPoll().getId());
        voteRepository.save(vote);
    }
}
