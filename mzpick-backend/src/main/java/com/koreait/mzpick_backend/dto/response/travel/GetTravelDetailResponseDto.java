package com.koreait.mzpick_backend.dto.response.travel;
// 여행지 리스트 보기 요청 dto

import com.koreait.mzpick_backend.common.object.Travel;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;
import com.koreait.mzpick_backend.entity.travel.TravelEntity;
import com.koreait.mzpick_backend.entity.travel.TravelHashtagEntity;
import com.koreait.mzpick_backend.entity.travel.TravelLikeEntity;
import com.koreait.mzpick_backend.entity.travel.TravelPhotoEntity;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;

@Getter

public class GetTravelDetailResponseDto extends ResponseDto{
    
    private List<Travel> travels;

    private GetTravelDetailResponseDto(List<TravelEntity> travelEntities,List<TravelPhotoEntity> travelPhotoEntities, List<TravelHashtagEntity> travelHashtagEntities, List<TravelLikeEntity> travelLikeEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.travels = Travel.getList(travelEntities, travelPhotoEntities, travelHashtagEntities, travelLikeEntities);
    }

     public static ResponseEntity<GetTravelDetailResponseDto> success(List<TravelEntity> travelEntities, List<TravelPhotoEntity> travelPhotoEntities, List<TravelHashtagEntity> travelHashtagEntities, List<TravelLikeEntity> travelLikeEntities) {
        GetTravelDetailResponseDto responseBody = new GetTravelDetailResponseDto(travelEntities, travelPhotoEntities, travelHashtagEntities, travelLikeEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
