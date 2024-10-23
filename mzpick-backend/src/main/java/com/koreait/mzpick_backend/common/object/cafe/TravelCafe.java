package com.koreait.mzpick_backend.common.object.cafe;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.cafe.TravelCafeCategoryEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafeHashtagEntity;
import com.koreait.mzpick_backend.entity.cafe.TravelCafePhotoEntity;

import lombok.Getter;

@Getter
public class TravelCafe {
    private Integer traveCafeNumber;
    private List<String> travelCafeCategory;
    private List<String> travelCafePhoto;
    private List<String> travelCafeHashtag;
    private Integer travelCafeLike;
    private Integer travelCafeView;
    private LocalDate travelCafeDate;

    public TravelCafe (TravelCafeEntity travelCafeEntity, List<TravelCafePhotoEntity> travelCafePhotoEntities, List<TravelCafeHashtagEntity> travelCafeHashtagEntities, List<TravelCafeCategoryEntity> travelCafeCategoryEntities ) {
        List<String> travelCafePhoto = new ArrayList<>();
        for (TravelCafePhotoEntity travelCafePhotoEntity: travelCafePhotoEntities) travelCafePhoto.add(travelCafePhotoEntity.getTravelCafePhotoLink());
        
        List<String> travelCafeHashtag = new ArrayList<>();
        for (TravelCafeHashtagEntity travelCafeHashtagEntity: travelCafeHashtagEntities) travelCafeHashtag.add(travelCafeHashtagEntity.getTravelCafeHashtagContent());
        
        List<String> travelCafeCategory = new ArrayList<>();
        for (TravelCafeCategoryEntity TravelCafeCategoryEntity: travelCafeCategoryEntities) travelCafeCategory.add(TravelCafeCategoryEntity.getTravelCafeCategoryContent());
        this.traveCafeNumber = travelCafeEntity.getTravelCafeNumber();
        this.travelCafePhoto = travelCafePhoto;
        this.travelCafeHashtag = travelCafeHashtag;
        this.travelCafeCategory = travelCafeCategory;
        this.travelCafeLike = travelCafeEntity.getTravelCafeLikeCount();
        this.travelCafeView = travelCafeEntity.getTravelCafeViewCount();
        this.travelCafeDate = travelCafeEntity.getTravelCafeDate();
        
    }

    public static List<TravelCafe> getList(List<TravelCafeEntity> travelCafeEntities, List<TravelCafePhotoEntity> travelCafePhotoEntities, List<TravelCafeHashtagEntity> travelCafeHashtagEntities, List<TravelCafeCategoryEntity> travelCafeCategoryEntities ) {
        List<TravelCafe> travelCafes = new ArrayList<>();

        for (TravelCafeEntity travelCafeEntity: travelCafeEntities) {
            TravelCafe travelCafe = new TravelCafe(travelCafeEntity, travelCafePhotoEntities, travelCafeHashtagEntities, travelCafeCategoryEntities);
            travelCafes.add(travelCafe);
        }
        return travelCafes;
    }
}

