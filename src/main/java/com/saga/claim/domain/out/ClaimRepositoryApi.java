package com.saga.claim.domain.out;

public interface ClaimRepositoryApi {

    void createClaim(String orderId, Integer itemId, Integer merchantInventoryId);
}
