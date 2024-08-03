package com.saga.claim.application.messaging.consumer;

import com.saga.claim.application.mapper.ClaimMapper;
import com.saga.claim.application.messaging.api.ClaimUpdate;
import com.saga.claim.application.messaging.api.CreateClaim;
import com.saga.claim.application.messaging.api.ShipmentUpdate;
import com.saga.claim.domain.in.ClaimDomainServiceApi;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
public class ClaimConsumer {
    private final ClaimDomainServiceApi claimDomainServiceApi;
    private final ClaimMapper claimMapper;

    @Bean
    public Consumer<Message<CreateClaim>> createClaim() {
        return msg -> {
            CreateClaim claim = msg.getPayload();
            claimDomainServiceApi.createClaim(
                    claim.orderId(),
                    claim.itemId(),
                    claim.merchantInventoryId(),
                    claim.customerId(),
                    claim.recipientId());
        };
    }

    @Bean
    public Consumer<Message<ClaimUpdate>> updateClaim() {
        return msg -> {
            claimDomainServiceApi.assignShipmentToClaim(claimMapper.fromUpdateMessage(msg.getPayload()));
        };
    }

    @Bean
    public Consumer<Message<ShipmentUpdate>> shipmentUpdate() {
        return msg -> {
            ShipmentUpdate shipmentUpdate = msg.getPayload();
            claimDomainServiceApi.updateClaimByShipmentStatus(
                    shipmentUpdate.claim().id(), claimMapper.fromShipmentStatus(shipmentUpdate.status()));
        };
    }
}
