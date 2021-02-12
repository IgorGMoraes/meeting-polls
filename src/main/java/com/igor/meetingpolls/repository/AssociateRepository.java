package com.igor.meetingpolls.repository;

import com.igor.meetingpolls.model.Associate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AssociateRepository extends JpaRepository<Associate, UUID> {
    Associate findByCpf(String cpf);
}
