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
public class TravelDetail {
    private String travelTitle;
    private List<String> travelPhoto;
    private List<String> travelHashtag;
    private List<String> travelLike;
    private Integer travelView;
    private LocalDate travelDate;

    public TravelDetail(TravelEntity travelEntity, List<TravelPhotoEntity> travelPhotoEntities, List<TravelHashtagEntity> travelHashtagEntities, List<TravelLikeEntity> travelLikeEntities) {

        List<String> travelPhoto = new ArrayList<>();
        for (TravelPhotoEntity travelPhotoEntity: travelPhotoEntities) travelPhoto.add(travelPhotoEntity.getTravelPhotoLink());
        
        List<String> travelHashtag = new ArrayList<>();
        for (TravelHashtagEntity travelHashtagEntitiy: travelHashtagEntities) travelHashtag.add(travelHashtagEntitiy.getTravelHashtagContent());
        
        List<String> travelLike = new ArrayList<>();
        for (TravelLikeEntity travelLikeEntity: travelLikeEntities) travelHashtag.add(travelLikeEntity.getUserId());

        this.travelTitle = travelEntity.getTravelTitle();
        this.travelPhoto = travelPhoto;
        this.travelHashtag = travelHashtag;
        this.travelLike = travelLike;
        this.travelView = travelEntity.getTravelViewCount();
        this.travelDate = travelEntity.getTravelDate();
    }

    // public static List<TravelDetail> getDetail(List<TravelEntity> travelEntities, List<TravelPhotoEntity> travelPhotoEntities, List<TravelHashtagEntity> travelHashtagEntities, List<TravelLikeEntity> travelLikeEntities) {
    //     List<TravelDetail> travelDetails = new ArrayList<>();

    //     for (TravelEntity travelEntity: travelEntities) {
    //         TravelDetail travelDetail = new TravelDetail(travelEntity, travelPhotoEntities, travelHashtagEntities, travelLikeEntities);
    //         travelDetails.add(travelDetail);
    //     }
    //     return travelDetails;
    // }
}

