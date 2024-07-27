package com.saga.claim.domain.out;

import com.saga.claim.domain.model.Claim;

import java.util.Optional;

public interface ClaimRepositoryApi {

    void createClaim(String orderId, Integer itemId, Integer merchantInventoryId);

    Optional<Claim> getClaimById(Integer claimId);
}
