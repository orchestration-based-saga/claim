package com.saga.claim.application.mapper;

import com.saga.claim.application.api.enums.ShipmentStatus;
import com.saga.claim.application.api.event.ClaimResponseMessage;
import com.saga.claim.application.api.event.ClaimMessage;
import com.saga.claim.application.api.event.ItemServicingProcessRequest;
import com.saga.claim.application.api.request.RefundRequest;
import com.saga.claim.application.api.response.ClaimResponse;
import com.saga.claim.domain.model.Claim;
import com.saga.claim.domain.model.ItemServicingRequest;
import com.saga.claim.domain.model.Refund;
import com.saga.claim.domain.model.enums.ShipmentStatusDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ClaimMapper {

    @Mapping(target = "refundAmount", ignore = true)
    @Mapping(target = "customerId", ignore = true)
    @Mapping(target = "recipientId", ignore = true)
    @Mapping(target = "businessKey", ignore = true)
    Claim fromUpdateMessage(ClaimMessage claimUpdateMessage);

    ShipmentStatusDomain fromShipmentStatus(ShipmentStatus shipmentStatus);

    ClaimResponse toResponse(Claim claim);

    Refund toDomain(RefundRequest request);

    ItemServicingRequest toItemServicingRequest(ItemServicingProcessRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "shipmentId", ignore = true)
    @Mapping(target = "refundAmount", ignore = true)
    @Mapping(target = "status", ignore = true)
    Claim fromCreateMessage(ClaimMessage message, String businessKey);

    ClaimResponseMessage toClaimResponse(Claim claim, Boolean shipmentInitiated);
}
