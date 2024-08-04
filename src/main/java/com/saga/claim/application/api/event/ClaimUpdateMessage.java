package com.saga.claim.application.api.event;

import com.saga.claim.application.api.enums.ClaimState;

public record ClaimUpdateMessage(
        Integer claimId,
        Integer shipmentId,
        ClaimState status
) {
}