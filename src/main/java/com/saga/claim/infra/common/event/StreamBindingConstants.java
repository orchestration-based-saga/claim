package com.saga.claim.infra.common.event;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamBindingConstants {
    public static final String CLAIM = "claim";
    public static final String CREATE_CLAIM_RESPONSE = "workflow-claim-create-response";
    public static final String UPDATE_CLAIM_RESPONSE = "workflow-claim-update-response";
    public static final String REFUND = "workflow-start-refund-request";
}
