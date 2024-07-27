package com.saga.claim.domain.service;

import com.saga.claim.domain.in.ClaimDomainServiceApi;
import com.saga.claim.domain.out.ClaimRepositoryApi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClaimDomainService implements ClaimDomainServiceApi {

    private final ClaimRepositoryApi claimRepositoryApi;

    @Override
    public void createClaim(String orderId, Integer itemId, Integer merchantInventoryId){
        claimRepositoryApi.createClaim(orderId, itemId, merchantInventoryId);
    }
}
