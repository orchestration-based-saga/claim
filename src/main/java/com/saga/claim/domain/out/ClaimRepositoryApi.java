package com.saga.claim.domain.out;

import com.saga.claim.domain.model.Claim;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClaimRepositoryApi {

    void createClaim(String orderId, Integer itemId, Integer merchantInventoryId, UUID customerId, UUID recipientId);

    Optional<Claim> getClaimById(Integer claimId);

    void save(Claim claim);

    List<Claim> getAll();
}
