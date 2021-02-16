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
@Builder
public class Associate {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String cpf;

}
