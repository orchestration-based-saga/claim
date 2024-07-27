package com.saga.claim.domain.out;

import com.saga.claim.domain.model.Claim;

public interface ClaimProducerApi {
    void sendClaim(Claim claim);
}
