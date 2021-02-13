package com.igor.meetingpolls.controller.v1;

import com.igor.meetingpolls.model.Poll;
import com.igor.meetingpolls.repository.PollRepository;
import com.igor.meetingpolls.service.PollService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/poll")
@RequiredArgsConstructor
public class PollController {

    private final PollRepository pollRepository;
    private final PollService pollService;

    @PostMapping("/")
    public Poll createPoll(@RequestBody Poll poll){
        return pollRepository.save(poll);
    }

    @GetMapping("/")
    public List<Poll> getPolls(){
        return pollRepository.findAll();
    }

    @PutMapping("/openVotation/{pollId}")
    public void openVotation(@PathVariable String pollId,
                                       @RequestBody(required = false) Optional<Integer> minutes){
        pollService.openPollForVotation(pollId, minutes);
//        return null;
    }
}
