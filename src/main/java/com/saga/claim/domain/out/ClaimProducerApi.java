package com.saga.claim.domain.out;

import com.saga.claim.domain.model.Claim;
import com.saga.claim.domain.model.ItemServicingRequest;

public interface ClaimProducerApi {

    void sendClaim(Claim claim);

    void sendCreateClaimResponse(Claim claim, Boolean shipmentInitiated);

    void sendUpdateClaimResponse(Claim claim, ItemServicingRequest request);
}
