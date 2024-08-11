package com.saga.claim.application.api.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.saga.claim.application.api.enums.ClaimState;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ClaimMessage(
        Integer id,
        String orderId,
        Integer itemId,
        Integer merchantInventoryId,
        UUID customerId,
        UUID recipientId,
        Integer shipmentId,
        ClaimState status
) {
}

