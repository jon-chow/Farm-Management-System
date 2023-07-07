package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import model.enums.AnimalType;
import model.enums.CropType;

import java.sql.Date;

@AllArgsConstructor
@Builder
@Getter
public class LivestockDto {
    private final int tagID;
    private final AnimalType animalType;
    private final int age;
    private final CropType diet;
    private final double weight;
    private final Date lastFed;
    private final boolean harvestable;
    private final Date lastViolatedForHarvestedGoods;
}
