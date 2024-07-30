package com.saga.claim.domain.model;

import com.saga.claim.domain.model.enums.ClaimStatusDomain;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record Claim(
        Integer id,
        String orderId,
        Integer itemId,
        Integer merchantInventoryId,
        Integer shipmentId,
        BigDecimal refundAmount,
        ClaimStatusDomain status
) {

    public Claim updateStatus(ClaimStatusDomain status) {
        return new Claim(id, orderId, itemId, merchantInventoryId, shipmentId, refundAmount, status);
    }

    public Claim setShipmentId(Integer shipmentId) {
        return new Claim(id, orderId, itemId, merchantInventoryId, shipmentId, refundAmount, status);
    }

    public Claim updateRefundAmount(BigDecimal refundAmount) {
        return new Claim(id, orderId, itemId, merchantInventoryId, shipmentId, refundAmount, status);
    }
}
