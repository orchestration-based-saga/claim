package com.saga.claim.application.service;

import com.saga.claim.application.api.response.ClaimResponse;
import com.saga.claim.application.api.request.RefundRequest;
import com.saga.claim.application.api.request.StartShipmentRequest;
import com.saga.claim.application.mapper.ClaimMapper;
import com.saga.claim.domain.in.ClaimDomainServiceApi;
import com.saga.claim.domain.model.enums.ClaimStatusDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClaimService {

    private final ClaimDomainServiceApi claimDomainServiceApi;
    private final ClaimMapper claimMapper;

    public void createShipment(StartShipmentRequest request){
        if (request.start()) {
            claimDomainServiceApi.createShipment(request.claimId());
        }
    }

    public List<ClaimResponse> getAllActiveClaims(){
        return claimDomainServiceApi.getClaims()
                .stream()
                .filter(c -> !c.status().equals(ClaimStatusDomain.FINISHED))
                .map(claimMapper::toResponse)
                .toList();
    }

    public void initiateRefund(RefundRequest request){
        claimDomainServiceApi.initiateRefund(claimMapper.toDomain(request));
    }
}
