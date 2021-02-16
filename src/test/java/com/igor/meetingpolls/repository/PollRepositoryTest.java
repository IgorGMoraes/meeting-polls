package com.igor.meetingpolls.repository;

import com.igor.meetingpolls.model.Poll;
import com.igor.meetingpolls.utils.ModelUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class PollRepositoryTest {

    @Autowired
    private PollRepository pollRepository;

    @Test
    void should_savePoll_whenSuccessful(){
        Poll pollToBeSaved = ModelUtils.createPoll();
        Poll pollSaved = this.pollRepository.save(pollToBeSaved);
        Assertions.assertThat(pollSaved).isNotNull();
        Assertions.assertThat(pollSaved.getId()).isNotNull();
        Assertions.assertThat(pollSaved.getStatus()).isNotNull();
        Assertions.assertThat(pollSaved.getTitle()).isEqualTo(pollToBeSaved.getTitle());
    }

}