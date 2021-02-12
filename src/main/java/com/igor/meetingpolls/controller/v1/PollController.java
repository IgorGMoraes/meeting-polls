package com.igor.meetingpolls.controller.v1;

import com.igor.meetingpolls.model.Poll;
import com.igor.meetingpolls.repository.PollRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/poll")
@RequiredArgsConstructor
public class PollController {

    private final PollRepository pollRepository;

    @PostMapping("/")
    public Poll createPoll(@RequestBody Poll poll){
        return pollRepository.save(poll);
    }

//    @PutMapping(/)
}
