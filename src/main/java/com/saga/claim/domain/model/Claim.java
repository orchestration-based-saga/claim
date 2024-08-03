package com.saga.claim.domain.model;

import com.saga.claim.domain.model.enums.ClaimStatusDomain;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record Claim(
        Integer id,
        String orderId,
        Integer itemId,
        Integer merchantInventoryId,
        Integer shipmentId,
        BigDecimal refundAmount,
        ClaimStatusDomain status,
        UUID customerId,
        UUID recipientId
) {

    public Claim updateStatus(ClaimStatusDomain status) {
        return new Claim(id, orderId, itemId, merchantInventoryId, shipmentId, refundAmount, status, customerId, recipientId);
    }

    public Claim setShipmentId(Integer shipmentId) {
        return new Claim(id, orderId, itemId, merchantInventoryId, shipmentId, refundAmount, status, customerId, recipientId);
    }

    public Claim updateRefundAmount(BigDecimal refundAmount) {
        return new Claim(id, orderId, itemId, merchantInventoryId, shipmentId, refundAmount, status, customerId, recipientId);
    }
}
