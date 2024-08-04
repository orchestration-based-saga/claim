package com.saga.claim.application.api.request;

import java.math.BigDecimal;

public record RefundRequest(
        Integer claimId,
        Integer itemId,
        BigDecimal refundAmount
) {
}
