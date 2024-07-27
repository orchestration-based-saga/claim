package com.saga.claim.infra.mappers;

import com.saga.claim.domain.model.Claim;
import com.saga.claim.domain.model.enums.ClaimStatusDomain;
import com.saga.claim.infra.model.ClaimEntity;
import com.saga.claim.infra.model.enums.ClaimStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ClaimEntityMapper {

    ClaimStatusDomain toDomain(ClaimStatus claimStatus);

    @Mapping(target = "merchantInventoryId", source = "claimEntity.product.id")
    Claim toDomain(ClaimEntity claimEntity);
}
