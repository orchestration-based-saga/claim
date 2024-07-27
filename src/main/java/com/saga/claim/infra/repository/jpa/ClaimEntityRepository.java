package com.saga.claim.infra.repository.jpa;

import com.saga.claim.infra.model.ClaimEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimEntityRepository extends JpaRepository<ClaimEntity, Integer> {
}
