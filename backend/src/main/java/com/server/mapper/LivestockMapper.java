package com.server.mapper;

import com.server.model.models.livestock.LivestockModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface LivestockMapper {

    List<LivestockModel> getAllLivestock();
    void insertLivestock(@Param("livestock")LivestockModel livestockModel);
    void updateLivestock(@Param("livestock")LivestockModel livestockModel, @Param("tagID") int tagID);
    void deleteLivestock(@Param("tagID") int tagID);
}
