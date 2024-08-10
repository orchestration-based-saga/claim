package com.saga.claim.domain.in;

import com.saga.claim.domain.model.ItemServicingRequest;
import com.saga.claim.domain.model.Refund;
import com.saga.claim.domain.model.Claim;
import com.saga.claim.domain.model.enums.ShipmentStatusDomain;

import java.util.List;

public interface ClaimDomainServiceApi {

    void createClaim(Claim claim, ItemServicingRequest request);

    void createShipment(Integer claimId, Boolean shipmentInitiated);

    void assignShipmentToClaim(Claim claim);

    void updateClaimByShipmentStatus(Integer claimId, ShipmentStatusDomain shipmentStatus);

    List<Claim> getClaims();

    void initiateRefund(Refund refund);
}
