package com.saga.claim.application.api.request;

public record StartShipmentRequest(
        Integer claimId,
        boolean start
) {
}
