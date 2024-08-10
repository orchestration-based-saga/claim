package com.saga.claim.application.api.event;

import com.saga.claim.domain.model.Claim;

import java.util.UUID;

public record ItemServicingProcessResponse(
        Long id,
        String processId,
        String businessKey,
        Long parentProcessId,
        UUID workflow,
        Claim claim
)
{
}
