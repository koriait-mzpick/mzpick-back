package com.koreait.mzpick_backend.dto.response.travel;
// 여행지 리스트 보기 요청 dto

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.Travel;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;
import com.koreait.mzpick_backend.entity.travel.TravelEntity;

import lombok.Getter;

@Getter
public class GetTravelListResponseDto extends ResponseDto{

    private List<Travel> travels;

    private GetTravelListResponseDto(List<TravelEntity> travelEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.travels = Travel.getList(travelEntities);
    }

    public static ResponseEntity<GetTravelListResponseDto> success(List<TravelEntity> travelEntities) {
        GetTravelListResponseDto responseBody = new GetTravelListResponseDto(travelEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
