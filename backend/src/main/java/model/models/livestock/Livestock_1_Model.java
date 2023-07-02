package model.models.livestock;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import model.enums.AnimalType;
import model.enums.CropType;
import org.json.JSONObject;

@AllArgsConstructor
@Builder
@Getter
public class Livestock_1_Model {
    private final AnimalType animalType;
    private final CropType diet;
    private final double weight;


    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("animalType", animalType);
        json.put("diet", diet);
        json.put("weight", weight);
        return json;
    }

    public static Livestock_1_Model fromJSON(JSONObject json) {
        return new Livestock_1_Model(
                AnimalType.valueOf(json.getString("animalType").toUpperCase()),
                CropType.valueOf(json.getString("diet").toUpperCase()),
                json.getDouble("weight")
        );
    }
}
