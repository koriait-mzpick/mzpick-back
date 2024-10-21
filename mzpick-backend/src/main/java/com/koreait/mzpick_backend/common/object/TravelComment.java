package com.koreait.mzpick_backend.common.object;

import java.util.List;
import java.util.ArrayList;

import com.koreait.mzpick_backend.entity.travel.TravelCommentEntity;

import lombok.Getter;

@Getter
public class TravelComment {
    private String userId;
    private String travelComment;

    private TravelComment(TravelCommentEntity travelCommentEntity) {
        this.userId = travelCommentEntity.getUserId();
        this.travelComment = travelCommentEntity.getTravelComment();
    }

    public static List<TravelComment> getCommentList(List<TravelCommentEntity> travelCommentEntities) {
        List<TravelComment> travelComments = new ArrayList<>();

        for (TravelCommentEntity travelCommentEntity: travelCommentEntities) {
            TravelComment travelComment = new TravelComment(travelCommentEntity);
            travelComments.add(travelComment);
        }
        return travelComments;
    }
}

