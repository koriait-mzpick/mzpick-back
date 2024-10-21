package com.koreait.mzpick_backend.common.object;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;


import com.koreait.mzpick_backend.entity.travel.TravelCommentEntity;
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

    private TravelDetail(TravelEntity travelEntity, List<TravelPhotoEntity> travelPhotoEntities, List<TravelHashtagEntity> travelHashtagEntities, List<TravelLikeEntity> travelLikeEntities) {

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

    public static List<TravelDetail> getDetailList(List<TravelEntity> travelEntities, List<TravelPhotoEntity> travelPhotoEntities, List<TravelHashtagEntity> travelHashtagEntities, List<TravelLikeEntity> travelLikeEntities) {
        List<TravelDetail> travelComments = new ArrayList<>();

        for (TravelEntity travelEntity: travelEntities) {
            TravelDetail travelComment = new TravelDetail(travelEntity, travelPhotoEntities, travelHashtagEntities, travelLikeEntities);
            travelComments.add(travelComment);
        }
        return travelComments;
    }
}

