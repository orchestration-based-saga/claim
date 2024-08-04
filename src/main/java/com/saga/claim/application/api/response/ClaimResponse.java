package com.saga.claim.application.api.response;

import com.saga.claim.application.api.enums.ClaimState;

public record ClaimResponse(
        Integer id,
        Integer shipmentId,
        String orderId,
        Integer merchantInventoryId,
        Integer itemId,
        ClaimState status
) {
}
