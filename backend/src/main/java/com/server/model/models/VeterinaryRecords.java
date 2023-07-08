package com.server.model.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import com.server.model.enums.HealthStatus;
import oracle.sql.DATE;

@AllArgsConstructor
@Builder
@Getter
public class VeterinaryRecords {

    private final int tagID;

    private final int recordID;

    private final DATE date;

    private final HealthStatus status;
}
