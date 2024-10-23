package com.koreait.mzpick_backend.common.object.cafe;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.cafe.TravelCafeCategoryEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeHashtagEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeLikeEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafePhotoEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeSaveEntity;

import lombok.Getter;

@Getter
public class TravelCafeDetail {
    private Integer travelCafeNumber;
    private String travelCafeTitle;
    private List<String> travelCafeCategory;
    private List<String> travelCafePhotoList;
    private List<String> travelCafeHashtagList;
    private List<String> travelCafeLikeList;
    private List<String> travelCafeSaveList;
    private Integer travelCafeView;
    private LocalDate travelCafeDate;

    public TravelCafeDetail(TravelCafeEntity travelCafeEntity, List<TravelCafePhotoEntity> travelCafePhotoEntities, List<TravelCafeHashtagEntity> travelCafeHashtagEntities, List<TravelCafeLikeEntity> travelCafeLikeEntities, List<TravelCafeSaveEntity> travelCafeSaveEntities, List<TravelCafeCategoryEntity> travelCafeCategoryEntities){

        List<String> travelCafePhoto = new ArrayList<>();
        for (TravelCafePhotoEntity travelCafePhotoEntity: travelCafePhotoEntities) travelCafePhoto.add(travelCafePhotoEntity.getTravelCafePhotoLink());
        
        List<String> travelCafeHashtag = new ArrayList<>();
        for (TravelCafeHashtagEntity travelCafeHashtagEntitiy: travelCafeHashtagEntities) travelCafeHashtag.add(travelCafeHashtagEntitiy.getTravelCafeHashtagContent());
        
        List<String> travelCafeLike = new ArrayList<>();
        for (TravelCafeLikeEntity travelCafeLikeEntity: travelCafeLikeEntities) travelCafeLike.add(travelCafeLikeEntity.getUserId());

        List<String> travelCafeSave = new ArrayList<>();
        for (TravelCafeSaveEntity travelCafeSaveEntity: travelCafeSaveEntities) travelCafeSave.add(travelCafeSaveEntity.getUserId());

        List<String> travelCafeCategory = new ArrayList<>();
        for (TravelCafeCategoryEntity TravelCafeCategoryEntity: travelCafeCategoryEntities) travelCafeCategory.add(TravelCafeCategoryEntity.getTravelCafeCategoryContent());

        this.travelCafeNumber = travelCafeEntity.getTravelCafeNumber();
        this.travelCafeTitle = travelCafeEntity.getTravelCafeTitle();
        this.travelCafeCategory = travelCafeCategory;
        this.travelCafePhotoList = travelCafePhoto;
        this.travelCafeHashtagList = travelCafeHashtag;
        this.travelCafeLikeList = travelCafeLike;
        this.travelCafeSaveList = travelCafeSave;
        this.travelCafeView = travelCafeEntity.getTravelCafeViewCount();
        this.travelCafeDate = travelCafeEntity.getTravelCafeDate();
    }
}

