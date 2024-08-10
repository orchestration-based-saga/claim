package com.saga.claim.domain.out;

import com.saga.claim.domain.model.Claim;

import java.util.List;
import java.util.Optional;

public interface ClaimRepositoryApi {

    Claim createClaim(Claim claim, String businessKey);

    Optional<Claim> getClaimById(Integer claimId);

    void save(Claim claim);

    List<Claim> getAll();
}
