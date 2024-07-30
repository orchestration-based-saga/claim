package com.saga.claim.application.controller.api;

import java.math.BigDecimal;

public record RefundRequest(
        Integer claimId,
        Integer itemId,
        BigDecimal refundAmount
) {
}
