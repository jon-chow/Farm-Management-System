package com.server.model.models.crop;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import com.server.model.enums.CropStatus;
import com.server.model.enums.CropType;
import com.server.model.enums.CropVariant;

import org.json.JSONObject;

/**
 * The intent for this class is to update/store information about a single livestock
 */

@AllArgsConstructor
@Builder
@Getter
public class  CropModel {
    private final CropType cropType;
    private final CropVariant cropVariant;
    private final CropStatus cropStatus;
    private final int quantity;


    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("cropType", cropType.toString().toUpperCase());
        json.put("cropVariant", cropVariant.toString().toUpperCase());
        json.put("cropStatus", cropStatus.toString().toUpperCase());
        json.put("quantity", quantity);
        return json;
    }

    public static CropModel fromJSON(JSONObject json) {
        return new CropModel(
            CropType.valueOf(json.getString("cropType").toUpperCase()),
            CropVariant.valueOf(json.getString("cropVariant").toUpperCase()),
            CropStatus.valueOf(json.getString("cropStatus").toUpperCase()),
            json.getInt("quantity")
        );
    }
}
