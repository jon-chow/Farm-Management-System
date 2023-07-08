package com.server.service.interfaces;

import com.server.dto.CropDto;
import com.server.model.filters.CropsFilterModel;

import java.util.List;

public interface ICropService {

    public List<CropDto> getCrops();
    public List<CropDto> getFilteredCrops(CropsFilterModel cropsFilterModel);
}
