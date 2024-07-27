package com.saga.claim.application.messaging;

import com.saga.claim.application.messaging.api.CreateClaim;
import com.saga.claim.application.service.ClaimService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
public class ClaimConsumer {
    private final ClaimService claimService;

    @Bean
    public Consumer<Message<CreateClaim>> claim() {
        return msg -> {
            CreateClaim claim = msg.getPayload();
            claimService.createClaim(claim.orderId(), claim.itemId(), claim.merchantInventoryId());
        };
    }
}
