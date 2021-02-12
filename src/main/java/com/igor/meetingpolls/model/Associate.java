package com.igor.meetingpolls.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Associate {
    @Id
    private UUID id;
    private String cpf;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Poll> polls;

    public Associate(String cpf) {
        this.id = UUID.randomUUID();
        this.cpf = cpf;
        this.polls = Collections.emptySet();
    }
}
