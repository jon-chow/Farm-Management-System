package com.server.model.models.livestock;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import com.server.model.enums.AnimalType;
import org.json.JSONObject;

@AllArgsConstructor
@Builder
@Getter
public class Livestock_3_Model {
    private final AnimalType animalType;
    private final int age;
    private final boolean harvestable;

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("animalType", animalType);
        json.put("age", age);
        json.put("harvestable", harvestable);
        return json;
    }

    public static Livestock_3_Model fromJSON(JSONObject json) {
        return new Livestock_3_Model(
                AnimalType.valueOf(json.getString("animalType").toUpperCase()),
                json.getInt("age"),
                json.getBoolean("harvestable")
        );
    }
}
