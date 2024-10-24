package com.koreait.mzpick_backend.common.object.fashion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mzpick_backend.entity.fashion.FashionEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionHashtagEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionLikeEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionPhotoEntity;
import com.koreait.mzpick_backend.entity.fashion.FashionSaveEntity;

import lombok.Getter;

@Getter
public class Fashion {
    private Integer fashionNumber;
    private List<String> fashionPhotoList;
    private List<String> fashionHashtagList;
    private List<String> fashionLikeUserList;
    private List<String> fashionSaveUserList;
    private Integer totalPrice;
    private Integer fashionLike;
    private Integer fashionView;
    private LocalDate fashionDate;

    public Fashion(FashionEntity fashionEntity, List<FashionPhotoEntity> fashionPhotoEntities,
            List<FashionHashtagEntity> fashionHashtagEntities,
            List<FashionLikeEntity> fashionLikeEntities,
            List<FashionSaveEntity> fashionSaveEntities) {

        List<String> fashionPhotoList = new ArrayList<>();
        for (FashionPhotoEntity fashionPhotoEntity : fashionPhotoEntities)
            fashionPhotoList.add(fashionPhotoEntity.getFashionPhotoLink());
        List<String> fashionHashtagList = new ArrayList<>();
        for (FashionHashtagEntity fashionHashtagEntity : fashionHashtagEntities)
            fashionPhotoList.add(fashionHashtagEntity.getFashionHashtagContent());
        List<String> fashionLikeUserList = new ArrayList<>();
        for (FashionLikeEntity fashionLikeEntity : fashionLikeEntities)
            fashionLikeUserList.add(fashionLikeEntity.getUserId());
        List<String> fashionSaveUserList = new ArrayList<>();
        for (FashionSaveEntity fashionSaveEntity : fashionSaveEntities)
            fashionSaveUserList.add(fashionSaveEntity.getUserId());
        this.fashionNumber = fashionEntity.getFashionNumber();
        this.fashionPhotoList = fashionPhotoList;
        this.fashionHashtagList = fashionHashtagList;
        this.fashionLikeUserList = fashionLikeUserList;
        this.fashionSaveUserList = fashionSaveUserList;
        this.totalPrice = fashionEntity.getFashionTotalPrice();
        this.fashionLike = fashionEntity.getFashionLikeCount();
        this.fashionDate = fashionEntity.getFashionDate();
    }

    public static List<Fashion> getList(List<FashionEntity> fashionEntities,
            List<FashionPhotoEntity> fashionPhotoEntities, List<FashionHashtagEntity> fashionHashtagEntities,
            List<FashionLikeEntity> fashionLikeEntities, List<FashionSaveEntity> fashionSaveEntities) {
                
        List<Fashion> fashions = new ArrayList<>();
        for (FashionEntity fashionEntity : fashionEntities) {
            Fashion fashion = new Fashion(fashionEntity, fashionPhotoEntities, fashionHashtagEntities,
                    fashionLikeEntities, fashionSaveEntities);
            fashions.add(fashion);
        }
        return fashions;
    }
}
