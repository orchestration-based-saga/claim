package com.saga.claim.application.service;

import com.saga.claim.domain.in.ClaimDomainServiceApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClaimService {

    private final ClaimDomainServiceApi claimDomainServiceApi;

    public void createClaim(String orderId, Integer itemId, Integer merchantInventoryId) {
        claimDomainServiceApi.createClaim(orderId, itemId, merchantInventoryId);
    }
}
