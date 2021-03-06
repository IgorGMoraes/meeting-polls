package com.igor.meetingpolls.model;

import com.igor.meetingpolls.constants.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Poll {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String title;
    @Builder.Default
    private Status status = Status.NEW;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Vote> votes = new ArrayList<>();

    // > 0: ACCEPTED, < 0: REJECTED, == 0: DRAW
    private int result = 0;

    public void addVote(Vote vote){
        votes.add(vote);
    }

}
