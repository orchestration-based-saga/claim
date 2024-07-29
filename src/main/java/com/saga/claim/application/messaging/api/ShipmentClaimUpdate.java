package com.saga.claim.application.messaging.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.saga.claim.application.messaging.api.enums.ClaimState;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ShipmentClaimUpdate(
        Integer id,
        ClaimState status
) {
}
