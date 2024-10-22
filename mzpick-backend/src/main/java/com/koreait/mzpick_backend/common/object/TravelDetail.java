package com.koreait.mzpick_backend.common.object;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.travel.TravelEntity;
import com.koreait.mzpick_backend.entity.travel.TravelHashtagEntity;
import com.koreait.mzpick_backend.entity.travel.TravelLikeEntity;
import com.koreait.mzpick_backend.entity.travel.TravelPhotoEntity;
import com.koreait.mzpick_backend.entity.travel.TravelSaveEntity;

import lombok.Getter;

@Getter
public class TravelDetail {
    private Integer travelNumber;
    private String travelTitle;
    private List<String> travelPhotoList;
    private List<String> travelHashtagList;
    private List<String> travelLikeList;
    private List<String> travelSaveList;
    private Integer travelView;
    private LocalDate travelDate;

    public TravelDetail(TravelEntity travelEntity, List<TravelPhotoEntity> travelPhotoEntities, List<TravelHashtagEntity> travelHashtagEntities, List<TravelLikeEntity> travelLikeEntities, List<TravelSaveEntity> travelSaveEntities){

        List<String> travelPhoto = new ArrayList<>();
        for (TravelPhotoEntity travelPhotoEntity: travelPhotoEntities) travelPhoto.add(travelPhotoEntity.getTravelPhotoLink());
        
        List<String> travelHashtag = new ArrayList<>();
        for (TravelHashtagEntity travelHashtagEntitiy: travelHashtagEntities) travelHashtag.add(travelHashtagEntitiy.getTravelHashtagContent());
        
        List<String> travelLike = new ArrayList<>();
        for (TravelLikeEntity travelLikeEntity: travelLikeEntities) travelLike.add(travelLikeEntity.getUserId());

        List<String> travelSave = new ArrayList<>();
        for (TravelSaveEntity travelSaveEntity: travelSaveEntities) travelSave.add(travelSaveEntity.getUserId());

        this.travelNumber = travelEntity.getTravelNumber();
        this.travelTitle = travelEntity.getTravelTitle();
        this.travelPhotoList = travelPhoto;
        this.travelHashtagList = travelHashtag;
        this.travelLikeList = travelLike;
        this.travelSaveList = travelSave;
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

