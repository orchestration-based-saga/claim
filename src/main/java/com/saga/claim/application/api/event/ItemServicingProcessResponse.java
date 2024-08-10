package com.saga.claim.application.api.event;

public record ItemServicingProcessResponse(
        String processId,
        String businessKey,
        ClaimResponseMessage claim
) {
}
