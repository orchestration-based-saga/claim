package com.saga.claim.application.api.event;

import java.util.UUID;

public record CreateClaimMessage(
        String orderId,
        Integer itemId,
        Integer merchantInventoryId,
        UUID customerId,
        UUID recipientId
) {
}

