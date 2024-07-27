package com.saga.claim.domain.out;

import com.saga.claim.domain.model.Claim;

public interface ShipmentProducerApi {

    void createShipment(Claim claim);
}
