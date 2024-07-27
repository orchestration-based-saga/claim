package com.saga.claim.application.messaging.consumer;

import com.saga.claim.application.mapper.ClaimMapper;
import com.saga.claim.application.messaging.ClaimUpdate;
import com.saga.claim.application.messaging.api.CreateClaim;
import com.saga.claim.application.service.ClaimService;
import com.saga.claim.domain.in.ClaimDomainServiceApi;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Configuration
@RequiredArgsConstructor
public class ClaimConsumer {
    private final ClaimService claimService;
    private final ClaimDomainServiceApi claimDomainServiceApi;
    private final ClaimMapper claimMapper;

    @Bean
    public Consumer<Message<CreateClaim>> claim() {
        return msg -> {
            CreateClaim claim = msg.getPayload();
            claimService.createClaim(claim.orderId(), claim.itemId(), claim.merchantInventoryId());
        };
    }

    @Bean
    public Consumer<Message<ClaimUpdate>> updateClaim() {
        return msg -> {
            claimDomainServiceApi.updateClaim(claimMapper.fromUpdateMessage(msg.getPayload()));
        };
    }
}
