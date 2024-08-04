package com.saga.claim.application.api.event;

import com.saga.claim.application.api.enums.ClaimState;

import java.util.UUID;

public record CreateShipmentMessage(
        String orderId,
        Integer itemId,
        Integer merchantInventoryId,
        Integer claimId,
        ClaimState status,
        UUID customerId,
        UUID recipientId
) {
}
