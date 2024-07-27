package com.saga.claim.application.messaging;

import com.saga.claim.application.messaging.api.enums.ClaimState;

public record ClaimUpdate(
        Integer claimId,
        Integer shipmentId,
        ClaimState status
) {
}