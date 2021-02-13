package com.igor.meetingpolls.service;

import com.igor.meetingpolls.exception.ResourceNotFoundException;
import com.igor.meetingpolls.model.Poll;
import com.igor.meetingpolls.model.Status;
import com.igor.meetingpolls.repository.PollRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class PollServiceImpl implements PollService {
    private final PollRepository pollRepository;

    @Override
    public void openPollForVotation(String pollId, Optional<Integer> minutes) {
        Poll poll = pollRepository.findById(UUID.fromString(pollId))
                .orElseThrow(() -> new ResourceNotFoundException("Poll doesn't exist."));

        poll.setStatus(Status.OPEN);
        pollRepository.save(poll);
        closePollAfterTime(minutes, poll);
    }

    private void closePollAfterTime(Optional<Integer> minutes, Poll poll) {
        long delay = 6000;
        if (minutes.isPresent() && minutes.get() > 0) {
            delay *= minutes.get();
        }

        log.info("minutes {}", minutes);
        log.info("delay {}", delay);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                poll.setStatus(Status.CLOSED);
                pollRepository.save(poll);
            }
        }, 6000);
    }
}
