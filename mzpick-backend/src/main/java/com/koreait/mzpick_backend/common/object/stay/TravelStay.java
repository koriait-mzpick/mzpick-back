package com.koreait.mzpick_backend.common.object.stay;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.stay.TravelStayCategoryEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayHashtagEntity;
import com.koreait.mzpick_backend.entity.stay.TravelStayPhotoEntity;

import lombok.Getter;

@Getter
public class TravelStay {
    private Integer traveStayNumber;
    private List<String> travelStayPhoto;
    private List<String> travelStayHashtag;
    private List<String> travelStayCategory;
    private Integer travelStayLike;
    private Integer travelStayView;
    private LocalDate travelStayDate;

    public TravelStay (TravelStayEntity travelStayEntity, List<TravelStayPhotoEntity> travelStayPhotoEntities, List<TravelStayHashtagEntity> travelStayHashtagEntities, List<TravelStayCategoryEntity> travelStayCategoryEntities ) {
        List<String> travelStayPhoto = new ArrayList<>();
        for (TravelStayPhotoEntity travelStayPhotoEntity: travelStayPhotoEntities) travelStayPhoto.add(travelStayPhotoEntity.getTravelStayPhotoLink());
        
        List<String> travelStayHashtag = new ArrayList<>();
        for (TravelStayHashtagEntity travelStayHashtagEntity: travelStayHashtagEntities) travelStayHashtag.add(travelStayHashtagEntity.getTravelStayHashtagContent());
        
        List<String> travelStayCategory = new ArrayList<>();
        for (TravelStayCategoryEntity TravelStayCategoryEntity: travelStayCategoryEntities) travelStayCategory.add(TravelStayCategoryEntity.getTravelStayCategoryContent());
        this.traveStayNumber = travelStayEntity.getTravelStayNumber();
        this.travelStayPhoto = travelStayPhoto;
        this.travelStayHashtag = travelStayHashtag;
        this.travelStayCategory = travelStayCategory;
        this.travelStayLike = travelStayEntity.getTravelStayLikeCount();
        this.travelStayView = travelStayEntity.getTravelStayViewCount();
        this.travelStayDate = travelStayEntity.getTravelStayDate();
        
    }

    public static List<TravelStay> getList(List<TravelStayEntity> travelStayEntities, List<TravelStayPhotoEntity> travelStayPhotoEntities, List<TravelStayHashtagEntity> travelStayHashtagEntities, List<TravelStayCategoryEntity> travelStayCategoryEntities) {
        List<TravelStay> travelStays = new ArrayList<>();

        for (TravelStayEntity travelStayEntity: travelStayEntities) {
            TravelStay travelStay = new TravelStay(travelStayEntity, travelStayPhotoEntities, travelStayHashtagEntities, travelStayCategoryEntities);
            travelStays.add(travelStay);
        }
        return travelStays;
    }
}

