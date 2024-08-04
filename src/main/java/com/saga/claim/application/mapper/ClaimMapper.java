package com.saga.claim.application.mapper;

import com.saga.claim.application.api.response.ClaimResponse;
import com.saga.claim.application.api.request.RefundRequest;
import com.saga.claim.application.api.event.ClaimUpdateMessage;
import com.saga.claim.application.api.enums.ShipmentStatus;
import com.saga.claim.domain.model.Refund;
import com.saga.claim.domain.model.Claim;
import com.saga.claim.domain.model.enums.ShipmentStatusDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ClaimMapper {

    @Mapping(target = "id", source = "claimId")
    @Mapping(target = "orderId", ignore = true)
    @Mapping(target = "itemId", ignore = true)
    @Mapping(target = "merchantInventoryId", ignore = true)
    @Mapping(target = "refundAmount", ignore = true)
    @Mapping(target = "customerId", ignore = true)
    @Mapping(target = "recipientId", ignore = true)
    Claim fromUpdateMessage(ClaimUpdateMessage claimUpdateMessage);

    ShipmentStatusDomain fromShipmentStatus(ShipmentStatus shipmentStatus);

    ClaimResponse toResponse(Claim claim);

    Refund toDomain(RefundRequest request);
}
