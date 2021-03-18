package com.igor.meetingpolls.controller.v1;

import com.igor.meetingpolls.model.Poll;
import com.igor.meetingpolls.service.PollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/poll")
@RequiredArgsConstructor
public class PollController {

    private final PollService pollService;

    @PostMapping("/")
    public ResponseEntity<Poll> createPoll(@RequestBody Poll poll) {
        return ResponseEntity.ok(pollService.save(poll));
    }

    @GetMapping("/")
    public ResponseEntity<List<Poll>> getPolls() {
        return ResponseEntity.ok(pollService.findAll());
    }

    @PutMapping("/openVotation/{pollId}")
    public ResponseEntity<String> openVotation(@PathVariable String pollId,
                                               @RequestBody(required = false) Optional<Integer> minutes) {
        pollService.openPollForVote(pollId, minutes);
        return ResponseEntity.ok("Poll with id " + pollId + "is open to be voted.");
    }
}
