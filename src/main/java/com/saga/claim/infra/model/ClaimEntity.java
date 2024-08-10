package com.saga.claim.infra.model;

import com.saga.claim.infra.model.enums.ClaimStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "Claim")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClaimEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Enumerated(EnumType.STRING)
    ClaimStatus status;
    Integer shipmentId;
    String orderId;
    BigDecimal refundAmount;
    Integer itemId;
    @OneToOne
    @JoinColumn(name = "merchant_inventory_id", referencedColumnName = "id")
    MerchantProductEntity product;
    UUID customerId;
    UUID recipientId;
    String businessKey;
}
