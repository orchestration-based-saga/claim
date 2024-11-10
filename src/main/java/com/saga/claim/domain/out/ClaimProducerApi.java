package com.saga.claim.domain.out;

import com.saga.claim.domain.model.Claim;

import java.math.BigDecimal;

public interface ClaimProducerApi {

    void sendClaim(Claim claim);

    void sendCreateClaimResponse(Claim claim, Boolean shipmentInitiated);

    void sendUpdateClaimResponse(Claim claim);

    void initiateRefund(Claim claim, boolean isForRefund, BigDecimal refundAmount);
}
