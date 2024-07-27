package com.saga.claim.application.controller;

import com.saga.claim.application.controller.api.StartShipmentRequest;
import com.saga.claim.application.service.ClaimService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
