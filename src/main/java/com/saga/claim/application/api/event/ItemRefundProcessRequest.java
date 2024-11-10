package com.saga.claim.application.api.event;

import java.math.BigDecimal;

public record ItemRefundProcessRequest(
        String processId,
        String businessKey,
        boolean isForRefund,
        BigDecimal refundAmount,
        ClaimResponseMessage claim
) {
}
