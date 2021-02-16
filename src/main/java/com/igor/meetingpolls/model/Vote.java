package com.igor.meetingpolls.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Vote {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private UUID pollId;

    @ManyToOne
    private Associate associate;
    private boolean choice;

}
