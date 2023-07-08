package com.server.controller;

import com.server.bean.RestResult;
import com.server.dto.CropDto;
import com.server.model.enums.CropStatus;
import com.server.model.enums.CropType;
import com.server.model.enums.CropVariant;
import com.server.model.filters.CropsFilterModel;
import com.server.service.interfaces.ICropService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/api/crops")
public class CropController {
    @Autowired
    private ICropService system;

    /* -------------------------------------------------------------------------- */
    /*                               CROPS REQUESTS                               */
    /* -------------------------------------------------------------------------- */

    /**
     * Handles Retrieving Crop Requests
     * GET /api/crops
     */
    @GetMapping(value = "")
    public RestResult<List<CropDto>> getCrops(HttpServletRequest req, HttpServletResponse res) throws IOException {
        List<CropDto> crops = system.getCrops();
        return RestResult.success(crops);
    }

    /**
     * Handles Filtering Crops By: cropType, cropVariant, cropStatus,
     * minQuantity, maxQuantity
     * <p>
     * GET /api/crops/filteredValues
     */
    @GetMapping(value = "/filteredValues")
    @ResponseBody
    @SuppressWarnings("unchecked")
    public RestResult<List<CropDto>> getFilteredCrops(@RequestBody Map<String, Object> map) {
        // Check for if null for these values.
        CropType cropType = CropType.valueOf(map.get("cropType").toString().toUpperCase());
        CropVariant cropVariant = CropVariant.valueOf(map.get("cropVariant").toString().toUpperCase());
        CropStatus cropStatus = CropStatus.valueOf(map.get("cropStatus").toString().toUpperCase());

        Map<String, Object> quantity = (Map<String, Object>) map.get("quantity");
        int minQuantity = (int) quantity.get("min");
        int maxQuantity = (int) quantity.get("max");

        CropsFilterModel filterModel = CropsFilterModel.builder()
                .cropType(cropType)
                .cropVariant(cropVariant)
                .cropStatus(cropStatus)
                .minQuantity(minQuantity)
                .maxQuantity(maxQuantity)
                .build();

        List<CropDto> crops = system.getFilteredCrops(filterModel);
        return RestResult.success(crops);
    }

}
