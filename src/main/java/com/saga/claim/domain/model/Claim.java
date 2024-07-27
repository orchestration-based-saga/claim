package com.saga.claim.domain.model;

import com.saga.claim.domain.model.enums.ClaimStatusDomain;
import lombok.Builder;

@Builder
public record Claim(
        Integer id,
        String orderId,
        Integer itemId,
        Integer merchantInventoryId,
        Integer shipmentId,
        ClaimStatusDomain status
) {

    public Claim updateStatus(ClaimStatusDomain status) {
        return new Claim(id, orderId, itemId, merchantInventoryId, shipmentId, status);
    }
}
