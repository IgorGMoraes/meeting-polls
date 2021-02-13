package com.igor.meetingpolls.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vote {
    @Id
    private UUID id;

    private UUID pollId;

    @ManyToOne
    private Associate associate;
    private boolean choice;

    public Vote(UUID pollId, boolean choice, Associate associate) {
        this.id = UUID.randomUUID();
        this.pollId = pollId;
        this.choice = choice;
        this.associate = associate;
    }

}
