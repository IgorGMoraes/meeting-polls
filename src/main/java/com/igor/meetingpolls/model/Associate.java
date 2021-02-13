package com.igor.meetingpolls.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Associate {
    @Id
    private UUID id;
    private String cpf;

    public Associate(String cpf) {
        this.id = UUID.randomUUID();
        this.cpf = cpf;
    }
}
