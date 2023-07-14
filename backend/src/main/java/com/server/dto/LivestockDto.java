package com.server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import com.server.model.enums.AnimalType;
import com.server.model.enums.CropType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.sql.Date;

@AllArgsConstructor
@Builder
@Getter
public class LivestockDto {
    @SerializedName("tag_id")
    private int tagID;

    @SerializedName("animal_type")
    private final AnimalType animalType;

    @SerializedName("age")
    private final int age;

    @SerializedName("diet")
    private final CropType diet;

    @SerializedName("weight")
    private final double weight;

    @SerializedName("last_fed")
    private final Date lastFed;

    @SerializedName("harvestable")
    private final boolean harvestable;

    @SerializedName("last_violated_for_harvested_goods")
    private final Date lastViolatedForHarvestedGoods;
}
