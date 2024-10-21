package com.koreait.mzpick_backend.common.object;

import java.util.List;
import java.util.ArrayList;

import com.koreait.mzpick_backend.entity.travel.TravelCommentEntity;

import lombok.Getter;

@Getter
public class TravelDetail {
    private String name;
    private String userId;
    private String travelComment;

    private TravelDetail(TravelCommentEntity travelCommentEntity) {
        this.name = getName();
        this.userId = getUserId();
        this.travelComment = getTravelComment();
    }

    public static List<TravelDetail> getDetailList(List<TravelCommentEntity> travelCommentEntities) {
        List<TravelDetail> travelComments = new ArrayList<>();

        for (TravelCommentEntity travelCommentEntity: travelCommentEntities) {
            TravelDetail travelComment = new TravelDetail(travelCommentEntity);
            travelComments.add(travelComment);
        }
        return travelComments;
    }
}

