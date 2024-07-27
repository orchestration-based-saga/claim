package com.saga.claim.infra.config;

import com.saga.claim.domain.in.ClaimDomainServiceApi;
import com.saga.claim.domain.out.ClaimRepositoryApi;
import com.saga.claim.domain.out.ShipmentProducerApi;
import com.saga.claim.domain.service.ClaimDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceBeanConfiguration {

    @Bean
    public ClaimDomainServiceApi claimDomainServiceApi(ClaimRepositoryApi claimRepositoryApi,
                                                       ShipmentProducerApi shipmentProducerApi) {
        return new ClaimDomainService(claimRepositoryApi, shipmentProducerApi);
    }
}
