package com.saga.claim.application.mapper;

import com.saga.claim.application.controller.api.ClaimResponse;
import com.saga.claim.application.controller.api.RefundRequest;
import com.saga.claim.application.messaging.api.ClaimUpdate;
import com.saga.claim.application.messaging.api.enums.ShipmentStatus;
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
    Claim fromUpdateMessage(ClaimUpdate claimUpdate);

    ShipmentStatusDomain fromShipmentStatus(ShipmentStatus shipmentStatus);

    ClaimResponse toResponse(Claim claim);

    Refund toDomain(RefundRequest request);
}
