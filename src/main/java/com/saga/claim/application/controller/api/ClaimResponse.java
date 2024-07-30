package com.saga.claim.application.controller.api;

import com.saga.claim.application.messaging.api.enums.ClaimState;

public record ClaimResponse(
        Integer id,
        Integer shipmentId,
        String orderId,
        Integer merchantInventoryId,
        Integer itemId,
        ClaimState status
) {
}
