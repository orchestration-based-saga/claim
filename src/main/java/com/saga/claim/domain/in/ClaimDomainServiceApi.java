package com.saga.claim.domain.in;

public interface ClaimDomainServiceApi {

    void createClaim(String orderId, Integer itemId, Integer merchantInventoryId);
}
