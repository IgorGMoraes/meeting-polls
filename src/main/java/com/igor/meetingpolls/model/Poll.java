package com.igor.meetingpolls.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Poll {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String title;
    private Status status = Status.NEW;

    @OneToMany
    private List<Vote> votes;
    private Result result;

}
