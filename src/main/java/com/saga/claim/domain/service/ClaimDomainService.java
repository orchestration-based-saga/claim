package com.saga.claim.domain.service;

import com.saga.claim.domain.in.ClaimDomainServiceApi;
import com.saga.claim.domain.model.Claim;
import com.saga.claim.domain.model.ItemServicingRequest;
import com.saga.claim.domain.model.Refund;
import com.saga.claim.domain.model.enums.ClaimStatusDomain;
import com.saga.claim.domain.model.enums.ShipmentStatusDomain;
import com.saga.claim.domain.out.ClaimProducerApi;
import com.saga.claim.domain.out.ClaimRepositoryApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.protocol.types.Field;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
public class ClaimDomainService implements ClaimDomainServiceApi {

    private final ClaimRepositoryApi claimRepositoryApi;
    private final ClaimProducerApi claimProducerApi;

    @Override
    public void createClaim(Claim claim, ItemServicingRequest request) {
        claimRepositoryApi.createClaim(claim, request.businessKey());
    }

    @Override
    public void createShipment(Integer claimId, Boolean shipmentInitiated) {
        Optional<Claim> maybeClaim = claimRepositoryApi.getClaimById(claimId);
        if (maybeClaim.isEmpty()) {
            // todo replace exception with error
            throw new RuntimeException("Invalid claim id: " + claimId);
        }
        Claim claim = maybeClaim.get();
        claim = claim.updateStatus(ClaimStatusDomain.RETURNING_TO_WAREHOUSE);
        claimRepositoryApi.save(claim);
        log.info("Initiated shipment for claim: {}", claimId);
        claimProducerApi.sendCreateClaimResponse(claim, shipmentInitiated);
    }

    @Override
    public void assignShipmentToClaim(Claim claim) {
        Optional<Claim> maybeClaim = claimRepositoryApi.getClaimById(claim.id());
        if (maybeClaim.isEmpty()) {
            throw new RuntimeException("Couldn't find claim with id: " + "on update claim event");
        }
        Claim claimToUpdate = maybeClaim.get();
        if (claim.status() != null) {
            claimToUpdate = claimToUpdate.updateStatus(claim.status());
        }
        if (claim.shipmentId() != null) {
            claimToUpdate = claimToUpdate.setShipmentId(claim.shipmentId());
        }
        claimToUpdate = claimRepositoryApi.save(claimToUpdate);
        claimProducerApi.sendUpdateClaimResponse(claimToUpdate);
    }

    @Override
    public void updateClaimByShipmentStatus(Integer claimId, ShipmentStatusDomain shipmentStatus) {
        Optional<Claim> maybeClaim = claimRepositoryApi.getClaimById(claimId);
        if (maybeClaim.isEmpty()) {
            throw new RuntimeException("Couldn't find claim with id: " + "on update claim event");
        }
        Claim claimToUpdate = maybeClaim.get();
        if (shipmentStatus.equals(ShipmentStatusDomain.DELIVERED)) {
            claimToUpdate = claimToUpdate.updateStatus(ClaimStatusDomain.DELIVERED);

        }
        claimRepositoryApi.save(claimToUpdate);
        claimProducerApi.sendClaim(claimToUpdate);
    }

    @Override
    public List<Claim> getClaims() {
        return claimRepositoryApi.getAll();
    }

    @Override
    public void initiateRefund(Refund refund) {
        Optional<Claim> maybeClaim = claimRepositoryApi.getClaimById(refund.claimId());
        if (maybeClaim.isEmpty()) {
            throw new RuntimeException("Couldn't find claim with id: " + "on refund request");
        }
        Claim claim = maybeClaim.get();
        boolean isForRefund = refund.refundAmount().compareTo(BigDecimal.ZERO) != 0;
        var status = isForRefund ? ClaimStatusDomain.REFUNDED: ClaimStatusDomain.FINISHED;
        claim = claim.updateStatus(status);
        claim = claim.updateRefundAmount(refund.refundAmount());


        claimRepositoryApi.save(claim);
        claimProducerApi.initiateRefund(claim, isForRefund, refund.refundAmount());
    }
}
