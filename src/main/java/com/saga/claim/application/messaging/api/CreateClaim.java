package com.saga.claim.application.messaging.api;

public record CreateClaim(
        String orderId,
        Integer itemId,
        Integer merchantInventoryId
) {
}

