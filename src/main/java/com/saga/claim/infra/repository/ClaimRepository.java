package com.saga.claim.infra.repository;

import com.saga.claim.domain.model.Claim;
import com.saga.claim.domain.out.ClaimRepositoryApi;
import com.saga.claim.infra.mappers.ClaimEntityMapper;
import com.saga.claim.infra.model.ClaimEntity;
import com.saga.claim.infra.model.MerchantProductEntity;
import com.saga.claim.infra.model.enums.ClaimStatus;
import com.saga.claim.infra.repository.jpa.ClaimEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ClaimRepository implements ClaimRepositoryApi {
    private final ClaimEntityRepository claimEntityRepository;
    private final ClaimEntityMapper mapper;

    @Override
    public void createClaim(String orderId, Integer itemId, Integer merchantInventoryId, UUID customerId, UUID recipientId) {
        claimEntityRepository.save(ClaimEntity.builder()
                .itemId(itemId)
                .orderId(orderId)
                .product(MerchantProductEntity.builder()
                        .id(merchantInventoryId)
                        .build())
                .status(ClaimStatus.CREATED)
                .customerId(customerId)
                .recipientId(recipientId)
                .build());
    }

    @Override
    public Optional<Claim> getClaimById(Integer claimId) {
        return claimEntityRepository.findById(claimId).map(mapper::toDomain);
    }

    @Override
    public void save(Claim claim) {
        claimEntityRepository.save(mapper.toEntity(claim));
    }

    @Override
    public List<Claim> getAll() {
        return mapper.toDomain(claimEntityRepository.findAll());
    }
}
