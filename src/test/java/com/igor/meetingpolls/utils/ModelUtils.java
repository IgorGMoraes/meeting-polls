package com.igor.meetingpolls.utils;

import com.igor.meetingpolls.model.Associate;
import com.igor.meetingpolls.model.Poll;
import com.igor.meetingpolls.model.Vote;

public class ModelUtils {
    public static final String CPF = "95547419010";

    public static Associate createAssociate() {
        return Associate.builder().cpf(CPF).build();
    }

    public static Poll createPoll(){
        return Poll.builder()
                .title("Test poll title")
                .build();
    }

    public static Vote createVote() {
        Associate associate = Associate.builder().cpf(CPF).build();
        return Vote.builder()
                .associate(associate)
                .choice(true)
                .build();
    }
}
