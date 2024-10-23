package com.koreait.mzpick_backend.common.object.stay;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.stay.TravelStayCategoryEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayHashtagEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayLikeEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayPhotoEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStaySaveEntity;

import lombok.Getter;

@Getter
public class TravelStayDetail {
    private Integer travelStayNumber;
    private String travelStayTitle;
    private List<String> travelStayCategory;
    private List<String> travelStayPhotoList;
    private List<String> travelStayHashtagList;
    private List<String> travelStayLikeList;
    private List<String> travelStaySaveList;
    private Integer travelStayView;
    private LocalDate travelStayDate;

    public TravelStayDetail(TravelStayEntity travelStayEntity, List<TravelStayPhotoEntity> travelStayPhotoEntities, List<TravelStayHashtagEntity> travelStayHashtagEntities, List<TravelStayLikeEntity> travelStayLikeEntities, List<TravelStaySaveEntity> travelStaySaveEntities, List<TravelStayCategoryEntity> travelStayCategoryEntities){

        List<String> travelStayCategory = new ArrayList<>();
        for (TravelStayCategoryEntity travelStayCategoryEntity: travelStayCategoryEntities) travelStayCategory.add(travelStayCategoryEntity.getTravelStayCategoryContent());

        List<String> travelStayPhoto = new ArrayList<>();
        for (TravelStayPhotoEntity travelStayPhotoEntity: travelStayPhotoEntities) travelStayPhoto.add(travelStayPhotoEntity.getTravelStayPhotoLink());
        
        List<String> travelStayHashtag = new ArrayList<>();
        for (TravelStayHashtagEntity travelStayHashtagEntitiy: travelStayHashtagEntities) travelStayHashtag.add(travelStayHashtagEntitiy.getTravelStayHashtagContent());
        
        List<String> travelStayLike = new ArrayList<>();
        for (TravelStayLikeEntity travelStayLikeEntity: travelStayLikeEntities) travelStayLike.add(travelStayLikeEntity.getUserId());

        List<String> travelStaySave = new ArrayList<>();
        for (TravelStaySaveEntity travelStaySaveEntity: travelStaySaveEntities) travelStaySave.add(travelStaySaveEntity.getUserId());

        this.travelStayNumber = travelStayEntity.getTravelStayNumber();
        this.travelStayTitle = travelStayEntity.getTravelStayTitle();
        this.travelStayCategory  = travelStayCategory;
        this.travelStayPhotoList = travelStayPhoto;
        this.travelStayHashtagList = travelStayHashtag;
        this.travelStayLikeList = travelStayLike;
        this.travelStaySaveList = travelStaySave;
        this.travelStayView = travelStayEntity.getTravelStayViewCount();
        this.travelStayDate = travelStayEntity.getTravelStayDate();
    }
}

