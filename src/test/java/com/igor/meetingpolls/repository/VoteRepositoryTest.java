package com.igor.meetingpolls.repository;

import com.igor.meetingpolls.model.Vote;
import com.igor.meetingpolls.utils.ModelUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class VoteRepositoryTest {

    public static final String CPF = "95547419010";
    @Autowired
    private VoteRepository voteRepository;

    @Test
    void should_saveVote_whenSuccessful() {
        Vote voteToBeSaved = ModelUtils.createVote();
        Vote voteSaved = this.voteRepository.save(voteToBeSaved);
        Assertions.assertThat(voteSaved).isNotNull().isEqualTo(voteToBeSaved);
        Assertions.assertThat(voteSaved.getId()).isNotNull();
        Assertions.assertThat(voteSaved.getAssociate()).isNotNull();
        Assertions.assertThat(voteSaved.getAssociate().getCpf()).isEqualTo(CPF);
    }

}