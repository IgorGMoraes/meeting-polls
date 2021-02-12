package com.igor.meetingpolls.service;

import com.igor.meetingpolls.configuration.RabbitConfig;
import com.igor.meetingpolls.constants.Constants;
import com.igor.meetingpolls.exception.ForbiddenException;
import com.igor.meetingpolls.exception.ResourceNotFoundException;
import com.igor.meetingpolls.model.*;
import com.igor.meetingpolls.repository.AssociateRepository;
import com.igor.meetingpolls.repository.PollRepository;
import com.igor.meetingpolls.repository.VoteRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import netscape.security.ForbiddenTargetException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class VoteServiceImpl implements VoteService {

    private final CpfValidatorServiceImpl cpfValidatorService;
    private final AssociateRepository associateRepository;
    private final PollRepository pollRepository;
    private final VoteRepository voteRepository;
    private final RabbitTemplate rabbitTemplate;
    private Associate associate;

    @Override
    public Vote createVote(String pollId, VoteRequest voteRequest) {
        String cpf = voteRequest.getCpf();

        Poll poll = Optional.of(pollRepository.findById(UUID.fromString(pollId))).get()
                .orElseThrow(() -> new ResourceNotFoundException("Poll doesn't exist"));

        if (Optional.ofNullable(associateRepository.findByCpf(cpf)).isPresent()) {
            log.info("Associate found");
            associate = associateRepository.findByCpf(cpf);
        } else {
            log.info("Creating new associate");
            associateRepository.save(new Associate(cpf));
        }

        validateAssociateBeforeVoting(cpf, poll, associate);

        associate.getPolls().add(poll);
        log.info("associate {}", associate);

        Vote vote = new Vote(poll, voteRequest.isChoice(), associate);
        log.info("Vote: {}", vote);
        rabbitTemplate.convertAndSend(Constants.EXCHANGE, Constants.ROUTING_KEY, vote);
        return vote;
    }

    private void validateAssociateBeforeVoting(String cpf, Poll poll, Associate associate) {
        log.info("Validating vote");
        if (!cpfValidatorService.isValidCpf(cpf)) {
            throw new ResourceNotFoundException("The associate with cpf " + cpf + " isn't able to vote.");
        }
        if (associate.getPolls().contains(poll)) {
            throw new ForbiddenException("The associate with cpf " + cpf + " had already voted for the poll " + poll.getTitle());
        }
    }
}
