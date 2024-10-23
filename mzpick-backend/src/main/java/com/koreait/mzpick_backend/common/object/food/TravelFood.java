package com.koreait.mzpick_backend.common.object.food;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.food.TravelFoodEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodHashtagEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodLikeEntity;
import com.koreait.mzpick_backend.entity.food.TravelFoodPhotoEntity;

import lombok.Getter;

@Getter
public class TravelFood {
    private Integer traveFoodNumber;
    private List<String> travelFoodPhoto;
    private List<String> travelFoodHashtag;
    private Integer travelFoodLike;
    private Integer travelFoodView;
    private LocalDate travelFoodDate;

    public TravelFood (TravelFoodEntity travelFoodEntity, List<TravelFoodPhotoEntity> travelFoodPhotoEntities, List<TravelFoodHashtagEntity> travelFoodHashtagEntities, List<TravelFoodLikeEntity> travelFoodLikeEntities ) {
        List<String> travelFoodPhoto = new ArrayList<>();
        for (TravelFoodPhotoEntity travelFoodPhotoEntity: travelFoodPhotoEntities) travelFoodPhoto.add(travelFoodPhotoEntity.getTravelFoodPhotoLink());
        
        List<String> travelFoodHashtag = new ArrayList<>();
        for (TravelFoodHashtagEntity travelFoodHashtagEntity: travelFoodHashtagEntities) travelFoodHashtag.add(travelFoodHashtagEntity.getTravelFoodHashtagContent());
        
        this.traveFoodNumber = travelFoodEntity.getTravelFoodNumber();
        this.travelFoodPhoto = travelFoodPhoto;
        this.travelFoodHashtag = travelFoodHashtag;
        this.travelFoodLike = travelFoodEntity.getTravelFoodLikeCount();
        this.travelFoodView = travelFoodEntity.getTravelFoodViewCount();
        this.travelFoodDate = travelFoodEntity.getTravelFoodDate();
        
    }

    public static List<TravelFood> getList(List<TravelFoodEntity> travelFoodEntities, List<TravelFoodPhotoEntity> travelFoodPhotoEntities, List<TravelFoodHashtagEntity> travelFoodHashtagEntities, List<TravelFoodLikeEntity> travelFoodLikeEntities ) {
        List<TravelFood> travelFoods = new ArrayList<>();

        for (TravelFoodEntity travelFoodEntity: travelFoodEntities) {
            TravelFood travelFood = new TravelFood(travelFoodEntity, travelFoodPhotoEntities, travelFoodHashtagEntities, travelFoodLikeEntities);
            travelFoods.add(travelFood);
        }
        return travelFoods;
    }
}

