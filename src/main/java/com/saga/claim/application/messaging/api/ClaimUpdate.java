package com.saga.claim.application.messaging.api;

import com.saga.claim.application.messaging.api.enums.ClaimState;

public record ClaimUpdate(
        Integer claimId,
        Integer shipmentId,
        ClaimState status
) {
}