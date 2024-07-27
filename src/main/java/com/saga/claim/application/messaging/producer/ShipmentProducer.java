package com.saga.claim.application.messaging.producer;

import com.saga.claim.application.messaging.api.CreateShipment;
import com.saga.claim.application.messaging.api.enums.ClaimState;
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
        streamBridge.send(StreamBindingConstants.SHIPMENT, MessageBuilder.withPayload(
                        new CreateShipment(
                                claim.orderId(),
                                claim.itemId(),
                                claim.merchantInventoryId(),
                                claim.id(),
                                ClaimState.valueOf(claim.status().name()))
                ).build()
        );
    }
}
