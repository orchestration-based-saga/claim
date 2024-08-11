package com.saga.claim.application.messaging.producer;

import com.saga.claim.application.api.enums.WorkflowConstants;
import com.saga.claim.application.api.event.ItemServicingProcessResponse;
import com.saga.claim.application.mapper.ClaimMapper;
import com.saga.claim.domain.model.Claim;
import com.saga.claim.domain.model.ItemServicingRequest;
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
    private final ClaimMapper claimMapper;

    @Override
    public void sendClaim(Claim claim) {
        streamBridge.send(StreamBindingConstants.CLAIM, MessageBuilder.withPayload(claim).build());
    }

    @Override
    public void sendCreateClaimResponse(Claim claim, Boolean shipmentInitiated) {
        ItemServicingProcessResponse response = new ItemServicingProcessResponse(
                WorkflowConstants.ITEM_SERVICING,
                claim.businessKey(),
                claimMapper.toClaimResponse(claim, shipmentInitiated)
        );
        streamBridge.send(StreamBindingConstants.CREATE_CLAIM_RESPONSE, MessageBuilder
                .withPayload(response)
                .build());
    }

    @Override
    public void sendUpdateClaimResponse(Claim claim, ItemServicingRequest request) {
        ItemServicingProcessResponse response = new ItemServicingProcessResponse(
                WorkflowConstants.ITEM_SERVICING,
                claim.businessKey(),
                claimMapper.toClaimResponse(claim, null)
        );
        streamBridge.send(StreamBindingConstants.UPDATE_CLAIM_RESPONSE, MessageBuilder
                .withPayload(response)
                .build());
    }
}
