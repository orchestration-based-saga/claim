package com.saga.claim.infra.repository;

import com.saga.claim.domain.model.Claim;
import com.saga.claim.domain.out.ClaimRepositoryApi;
import com.saga.claim.infra.mappers.ClaimEntityMapper;
import com.saga.claim.infra.model.ClaimEntity;
import com.saga.claim.infra.model.enums.ClaimStatus;
import com.saga.claim.infra.repository.jpa.ClaimEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ClaimRepository implements ClaimRepositoryApi {
    private final ClaimEntityRepository claimEntityRepository;
    private final ClaimEntityMapper mapper;

    @Override
    public void createClaim(Claim claim, String businessKey) {
        ClaimEntity claimEntity = mapper.toEntity(claim);
        claimEntity.setBusinessKey(businessKey);
        claimEntity.setStatus(ClaimStatus.CREATED);
        claimEntityRepository.save(claimEntity);
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
