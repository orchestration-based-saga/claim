package com.saga.claim.application.api.event;

import com.saga.claim.domain.model.Claim;

public record ItemServicingProcessResponse(
        String processId,
        String businessKey,
        Claim claim
) {
}
