package com.koreait.mzpick_backend.common.object;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.travel.TravelEntity;
import com.koreait.mzpick_backend.entity.travel.TravelHashtagEntity;
import com.koreait.mzpick_backend.entity.travel.TravelLikeEntity;
import com.koreait.mzpick_backend.entity.travel.TravelPhotoEntity;

import lombok.Getter;

@Getter
public class Travel {
    private Integer traveNumber;
    private List<String> travelPhoto;
    private List<String> travelHashtag;
    private Integer travelLike;
    private Integer travelView;
    private LocalDate travelDate;

    public Travel(TravelEntity travelEntity, List<TravelPhotoEntity> travelPhotoEntities, List<TravelHashtagEntity> travelHashtagEntities, List<TravelLikeEntity> travelLikeEntities ) {
        List<String> travelPhoto = new ArrayList<>();
        for (TravelPhotoEntity travelPhotoEntity: travelPhotoEntities) travelPhoto.add(travelPhotoEntity.getTravelPhotoLink());
        
        List<String> travelHashtag = new ArrayList<>();
        for (TravelHashtagEntity travelHashtagEntity: travelHashtagEntities) travelHashtag.add(travelHashtagEntity.getTravelHashtagContent());
        
        this.traveNumber = travelEntity.getTravelNumber();
        this.travelPhoto = travelPhoto;
        this.travelHashtag = travelHashtag;
        this.travelLike = travelEntity.getTravelLikeCount();
        this.travelView = travelEntity.getTravelViewCount();
        this.travelDate = travelEntity.getTravelDate();
        
    }

    public static List<Travel> getList(List<TravelEntity> travelEntities,List<TravelPhotoEntity> travelPhotoEntities, List<TravelHashtagEntity> travelHashtagEntities, List<TravelLikeEntity> travelLikeEntities ) {
        List<Travel> travels = new ArrayList<>();

        for (TravelEntity travelEntity: travelEntities) {
            Travel travel = new Travel(travelEntity, travelPhotoEntities, travelHashtagEntities, travelLikeEntities);
            travels.add(travel);
        }
        return travels;
    }
}

