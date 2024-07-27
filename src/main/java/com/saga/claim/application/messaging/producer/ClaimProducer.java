package com.saga.claim.application.messaging.producer;

import com.saga.claim.domain.model.Claim;
import com.saga.claim.domain.out.ClaimProducerApi;
import com.saga.claim.infra.common.event.StreamBindingConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClaimProducer implements ClaimProducerApi {
    private final StreamBridge streamBridge;

    @Override
    public void sendClaim(Claim claim) {
        streamBridge.send(StreamBindingConstants.CLAIM, MessageBuilder.withPayload(claim).build());
    }
}
