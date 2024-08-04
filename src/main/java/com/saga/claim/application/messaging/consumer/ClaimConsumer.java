package com.saga.claim.application.messaging.consumer;

import com.saga.claim.application.mapper.ClaimMapper;
import com.saga.claim.application.api.event.ClaimUpdateMessage;
import com.saga.claim.application.api.event.CreateClaimMessage;
import com.saga.claim.application.api.event.ShipmentUpdateMessage;
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
    public Consumer<Message<CreateClaimMessage>> createClaim() {
        return msg -> {
            CreateClaimMessage claim = msg.getPayload();
            claimDomainServiceApi.createClaim(
                    claim.orderId(),
                    claim.itemId(),
                    claim.merchantInventoryId(),
                    claim.customerId(),
                    claim.recipientId());
        };
    }

    @Bean
    public Consumer<Message<ClaimUpdateMessage>> updateClaim() {
        return msg -> {
            claimDomainServiceApi.assignShipmentToClaim(claimMapper.fromUpdateMessage(msg.getPayload()));
        };
    }

    @Bean
    public Consumer<Message<ShipmentUpdateMessage>> shipmentUpdate() {
        return msg -> {
            ShipmentUpdateMessage shipmentUpdateMessage = msg.getPayload();
            claimDomainServiceApi.updateClaimByShipmentStatus(
                    shipmentUpdateMessage.claim().id(), claimMapper.fromShipmentStatus(shipmentUpdateMessage.status()));
        };
    }
}
