package com.server.model.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import com.server.model.enums.CropType;
import com.server.model.enums.FieldState;

/**
 * The intent for this class is to update/store information about a single field
 */
@AllArgsConstructor
@Builder
@Getter
public class FieldModel {

    private final int plotNum;
    private final double nutrientLevels;
    private final CropType suitableCrops;
    private final int capacity;
    private final FieldState fieldState;
    private final boolean needPesticides;
}
