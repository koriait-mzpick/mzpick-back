package com.koreait.mzpick_backend.common.object.food;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.food.TravelFoodEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodHashtagEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodLikeEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodPhotoEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodSaveEntity;

import lombok.Getter;

@Getter
public class TravelFoodDetail {
    private Integer travelFoodNumber;
    private String travelFoodTitle;
    private List<String> travelFoodPhotoList;
    private List<String> travelFoodHashtagList;
    private List<String> travelFoodLikeList;
    private List<String> travelFoodSaveList;
    private Integer travelFoodView;
    private LocalDate travelFoodDate;

    public TravelFoodDetail(TravelFoodEntity travelFoodEntity, List<TravelFoodPhotoEntity> travelFoodPhotoEntities, List<TravelFoodHashtagEntity> travelFoodHashtagEntities, List<TravelFoodLikeEntity> travelFoodLikeEntities, List<TravelFoodSaveEntity> travelFoodSaveEntities){

        List<String> travelFoodPhoto = new ArrayList<>();
        for (TravelFoodPhotoEntity travelFoodPhotoEntity: travelFoodPhotoEntities) travelFoodPhoto.add(travelFoodPhotoEntity.getTravelFoodPhotoLink());
        
        List<String> travelFoodHashtag = new ArrayList<>();
        for (TravelFoodHashtagEntity travelFoodHashtagEntitiy: travelFoodHashtagEntities) travelFoodHashtag.add(travelFoodHashtagEntitiy.getTravelFoodHashtagContent());
        
        List<String> travelFoodLike = new ArrayList<>();
        for (TravelFoodLikeEntity travelFoodLikeEntity: travelFoodLikeEntities) travelFoodLike.add(travelFoodLikeEntity.getUserId());

        List<String> travelFoodSave = new ArrayList<>();
        for (TravelFoodSaveEntity travelFoodSaveEntity: travelFoodSaveEntities) travelFoodSave.add(travelFoodSaveEntity.getUserId());

        this.travelFoodNumber = travelFoodEntity.getTravelFoodNumber();
        this.travelFoodTitle = travelFoodEntity.getTravelFoodTitle();
        this.travelFoodPhotoList = travelFoodPhoto;
        this.travelFoodHashtagList = travelFoodHashtag;
        this.travelFoodLikeList = travelFoodLike;
        this.travelFoodSaveList = travelFoodSave;
        this.travelFoodView = travelFoodEntity.getTravelFoodViewCount();
        this.travelFoodDate = travelFoodEntity.getTravelFoodDate();
    }
}

