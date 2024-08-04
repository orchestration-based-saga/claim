package com.saga.claim.application.api.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.saga.claim.application.api.enums.ShipmentStatus;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ShipmentUpdateMessage(
        Integer id,
        ShipmentClaimUpdateMessage claim,
        ShipmentStatus status
) {
}
