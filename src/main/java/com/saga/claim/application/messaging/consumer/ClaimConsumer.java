package com.saga.claim.application.messaging.consumer;

import com.saga.claim.application.api.event.ItemServicingProcessRequest;
import com.saga.claim.application.api.event.ShipmentUpdateMessage;
import com.saga.claim.application.mapper.ClaimMapper;
import com.saga.claim.domain.in.ClaimDomainServiceApi;
import com.saga.claim.domain.model.Claim;
import com.saga.claim.domain.model.ItemServicingRequest;
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
    public Consumer<Message<ItemServicingProcessRequest>> createClaim() {
        return msg -> {
            ItemServicingProcessRequest request = msg.getPayload();
            ItemServicingRequest itemServicingRequest = claimMapper.toItemServicingRequest(request);
            Claim claim = claimMapper.fromCreateMessage(request.claim(), request.businessKey());
            claimDomainServiceApi.createClaim(claim, itemServicingRequest);
        };
    }

    @Bean
    public Consumer<Message<ItemServicingProcessRequest>> updateClaim() {
        return msg -> {
            ItemServicingProcessRequest request = msg.getPayload();
            Claim claim = claimMapper.fromUpdateMessage(request.claim());
            claimDomainServiceApi.assignShipmentToClaim(claim);
        };
    }

    @Bean
    public Consumer<Message<ShipmentUpdateMessage>> shipment() {
        return msg -> {
            ShipmentUpdateMessage message = msg.getPayload();
            claimDomainServiceApi.updateClaimByShipmentStatus(message.claim().id(),
                    claimMapper.fromShipmentStatus(message.status()));
        };
    }
}
