package com.server.service.impl;

import com.server.dto.CropDto;
import com.server.model.filters.CropsFilterModel;
import com.server.service.BaseService;
import com.server.service.interfaces.ICropService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CropService extends BaseService implements ICropService {
    @Override
    public List<CropDto> getCrops() {
        // TODO: implement
        return null;
    }

    @Override
    public List<CropDto> getFilteredCrops(CropsFilterModel cropsFilterModel) {
        // TODO: implement
        return null;
    }

}
