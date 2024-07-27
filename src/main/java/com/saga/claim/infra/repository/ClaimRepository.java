package com.saga.claim.infra.repository;

import com.saga.claim.domain.out.ClaimRepositoryApi;
import com.saga.claim.infra.model.ClaimEntity;
import com.saga.claim.infra.model.enums.ClaimStatus;
import com.saga.claim.infra.repository.jpa.ClaimEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ClaimRepository implements ClaimRepositoryApi {
    private final ClaimEntityRepository claimEntityRepository;

    @Override
    public void createClaim(String orderId, Integer itemId, Integer merchantInventoryId) {
        claimEntityRepository.save(ClaimEntity.builder()
                .itemId(itemId)
                .orderId(orderId)
                .merchantInventoryId(merchantInventoryId)
                .status(ClaimStatus.CREATED)
                .build());
    }

}
