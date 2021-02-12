package com.igor.meetingpolls.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vote {
    @Id
    private UUID id;

    @ManyToOne
    private Poll poll;

    @ManyToOne
    private Associate associate;
    private boolean choice;

    public Vote(Poll poll, boolean choice, Associate associate) {
        this.id = UUID.randomUUID();
        this.poll = poll;
        this.choice = choice;
        this.associate = associate;
    }


}
