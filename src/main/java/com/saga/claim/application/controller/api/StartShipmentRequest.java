package com.saga.claim.application.controller.api;

public record StartShipmentRequest(
        Integer claimId,
        boolean start
) {
}
