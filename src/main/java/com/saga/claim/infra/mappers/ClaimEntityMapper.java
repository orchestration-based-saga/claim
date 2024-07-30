package com.saga.claim.infra.mappers;

import com.saga.claim.domain.model.Claim;
import com.saga.claim.domain.model.enums.ClaimStatusDomain;
import com.saga.claim.infra.model.ClaimEntity;
import com.saga.claim.infra.model.MerchantProductEntity;
import com.saga.claim.infra.model.enums.ClaimStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface ClaimEntityMapper {

    ClaimStatusDomain toDomain(ClaimStatus claimStatus);
    ClaimStatus toEntity(ClaimStatusDomain status);

    @Mapping(target = "merchantInventoryId", source = "claimEntity.product.id")
    Claim toDomain(ClaimEntity claimEntity);

    List<Claim> toDomain(List<ClaimEntity> claimEntityList);

    @Mapping(target = "product", source = "claim.merchantInventoryId", qualifiedByName = "linkProduct")
    @Mapping(target = "refundAmount", ignore = true)
    ClaimEntity toEntity(Claim claim);

    @Named("linkProduct")
    default MerchantProductEntity linkProduct(Integer merchantInventoryId) {
        return MerchantProductEntity.builder()
                .id(merchantInventoryId)
                .build();
    }
}
