package com.saga.claim.application.api.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.saga.claim.application.api.enums.ClaimState;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ShipmentClaimUpdateMessage(
        Integer id,
        ClaimState status
) {
}
