package com.server.model.filters;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import com.server.model.enums.CropStatus;
import com.server.model.enums.CropType;
import com.server.model.enums.CropVariant;

@AllArgsConstructor
@Builder
@Getter
public class CropsFilterModel {

    private final CropType cropType;
    private final CropVariant cropVariant;
    private final CropStatus cropStatus;
    private final int minQuantity;
    private final int maxQuantity;

    /**
     *
     * @return something in the form of:
     * " WHERE (quantity >= minQuantity) AND (quantity <= maxQuantity)
     *      AND (cropType = cropType) AND (cropVariant = cropVariant) AND (cropStatus = cropStatus) "
     *
     */
    public String getQueryString() {
        String queryString = " WHERE ";

        // There will always be a min quantity and max quantity.


        if (minQuantity <= -1 && maxQuantity <= -1) {
            // no valid quantity val.
            queryString += " quantity >= " + 0 + " ";
        } else if (minQuantity > -1 && maxQuantity <= -1) {
            // valid min quantity val.
            queryString += " quantity >= " + minQuantity + " ";
        } else if (minQuantity <= -1 && maxQuantity > -1) {
            // valid max quantity val.
            queryString += " quantity <= " + maxQuantity + " ";
        } else {
            // both valid.
            queryString += " quantity >= " + minQuantity + " AND " + " quantity <= " + maxQuantity + " ";
        }

        if (getCropType() != CropType.ALL) {
            queryString += " AND (cropType = '" + cropType.toString().toLowerCase() + "') ";
        }

        if (getCropVariant() != CropVariant.ALL) {
            queryString += " AND (cropVariant = '" + cropVariant.toString().toLowerCase() + "') ";
        }

        if (getCropStatus() != CropStatus.ALL) {
            queryString += " AND (cropStatus = '" + cropStatus.toString().toLowerCase() + "') ";
        }

        return queryString;
    }
}
