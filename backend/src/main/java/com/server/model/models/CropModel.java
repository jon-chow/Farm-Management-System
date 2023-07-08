package com.server.model.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import com.server.model.enums.CropStatus;
import com.server.model.enums.CropType;
import com.server.model.enums.CropVariant;

/**
 * The intent for this class is to update/store information about a single crop
 */
@AllArgsConstructor
@Builder
@Getter
public class CropModel {
    private final CropType cropType;
    private final CropVariant cropVariant;
    private final CropStatus cropStatus;
    private final int quantity;
}
