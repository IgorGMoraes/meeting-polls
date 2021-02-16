package com.igor.meetingpolls.repository;

import com.igor.meetingpolls.model.Associate;
import com.igor.meetingpolls.utils.ModelUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class AssociateRepositoryTest {

    @Autowired
    private AssociateRepository associateRepository;

    @Test
    void should_findAssociate_whenSearchByCpf(){
        Associate associate = ModelUtils.createAssociate();
        associateRepository.save(associate);
        Assertions.assertThat(associateRepository.findByCpf(ModelUtils.CPF)).isEqualTo(associate);
    }

    @Test
    void should_not_findAssociate_whenSearchByCpf(){
        Associate associate = ModelUtils.createAssociate();
        associateRepository.save(associate);
        Assertions.assertThat(associateRepository.findByCpf("0")).isNull();
    }


}