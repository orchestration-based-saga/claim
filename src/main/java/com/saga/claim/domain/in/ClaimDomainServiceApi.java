package com.saga.claim.domain.in;

import com.saga.claim.domain.model.Claim;

public interface ClaimDomainServiceApi {

    void createClaim(String orderId, Integer itemId, Integer merchantInventoryId);

    void createShipment(Integer claimId);

    void updateClaim(Claim claim);
}
