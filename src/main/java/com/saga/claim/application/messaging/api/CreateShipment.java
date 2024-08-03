package com.saga.claim.application.messaging.api;

import com.saga.claim.application.messaging.api.enums.ClaimState;

import java.util.UUID;

public record CreateShipment(
        String orderId,
        Integer itemId,
        Integer merchantInventoryId,
        Integer claimId,
        ClaimState status,
        UUID customerId,
        UUID recipientId
) {
}
