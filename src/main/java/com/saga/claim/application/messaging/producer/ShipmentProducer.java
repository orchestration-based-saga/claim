package com.saga.claim.application.messaging.producer;

import com.saga.claim.application.api.event.CreateShipmentMessage;
import com.saga.claim.application.api.enums.ClaimState;
import com.saga.claim.domain.model.Claim;
import com.saga.claim.domain.out.ShipmentProducerApi;
import com.saga.claim.infra.common.event.StreamBindingConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShipmentProducer implements ShipmentProducerApi {

    private final StreamBridge streamBridge;

    @Override
    public void createShipment(Claim claim) {
        streamBridge.send(StreamBindingConstants.CREATE_SHIPMENT, MessageBuilder.withPayload(
                        new CreateShipmentMessage(
                                claim.orderId(),
                                claim.itemId(),
                                claim.merchantInventoryId(),
                                claim.id(),
                                ClaimState.valueOf(claim.status().name()),
                                claim.customerId(),
                                claim.recipientId())
                ).build()
        );
    }
}
