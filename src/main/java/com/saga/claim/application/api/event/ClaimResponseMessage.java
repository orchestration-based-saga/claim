package com.saga.claim.application.api.event;

import com.saga.claim.domain.model.enums.ClaimStatusDomain;

import java.math.BigDecimal;
import java.util.UUID;

public record ClaimResponseMessage (
        Integer id,
        String orderId,
        Integer itemId,
        Integer merchantInventoryId,
        Integer shipmentId,
        BigDecimal refundAmount,
        ClaimStatusDomain status,
        UUID customerId,
        UUID recipientId,
        Boolean shipmentInitiated
){
}
