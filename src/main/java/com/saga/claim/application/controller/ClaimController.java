package com.saga.claim.application.controller;

import com.saga.claim.application.api.response.ClaimResponse;
import com.saga.claim.application.api.request.RefundRequest;
import com.saga.claim.application.api.request.StartShipmentRequest;
import com.saga.claim.application.service.ClaimService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/claim")
@RequiredArgsConstructor
public class ClaimController {

    private final ClaimService claimService;

    @PostMapping("/shipment/initiate")
    public ResponseEntity<Void> initiateShipment(@RequestBody StartShipmentRequest request) {
        claimService.createShipment(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/active")
    public ResponseEntity<List<ClaimResponse>> getDeliveredClaims() {
        return ResponseEntity.ok(claimService.getAllActiveClaims());
    }

    @PostMapping("/refund")
    public ResponseEntity<Void> refundItems(@RequestBody RefundRequest request) {
        claimService.initiateRefund(request);
        return ResponseEntity.ok().build();

    }
}
