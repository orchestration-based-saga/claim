package com.saga.claim.application.messaging.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.saga.claim.application.messaging.api.enums.ShipmentStatus;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ShipmentUpdate(
        Integer id,
        ShipmentClaimUpdate claim,
        ShipmentStatus status
) {
}
