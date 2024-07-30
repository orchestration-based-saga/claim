package com.saga.claim.domain.model;

import java.math.BigDecimal;

public record Refund(
        Integer claimId,
        Integer itemId,
        BigDecimal refundAmount
) {
}
