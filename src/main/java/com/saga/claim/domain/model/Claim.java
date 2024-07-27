package com.saga.claim.domain.model;

import com.saga.claim.domain.model.enums.ClaimStatusDomain;

public record Claim(
        Integer id,
        String orderId,
        Integer itemId,
        Integer merchantInventoryId,
        Integer shipmentId,
        ClaimStatusDomain status
) {
}
