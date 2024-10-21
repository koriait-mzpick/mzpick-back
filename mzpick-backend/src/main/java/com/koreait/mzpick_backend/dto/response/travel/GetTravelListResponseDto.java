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
import com.koreait.mzpick_backend.entity.travel.TravelHashtagEntity;
import com.koreait.mzpick_backend.entity.travel.TravelLikeEntity;
import com.koreait.mzpick_backend.entity.travel.TravelPhotoEntity;

import lombok.Getter;

@Getter
public class GetTravelListResponseDto extends ResponseDto{

    private List<Travel> travels;

    private GetTravelListResponseDto(List<Travel> travels) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.travels = travels;
    }

    public static ResponseEntity<GetTravelListResponseDto> success(List<Travel> travels) {
        GetTravelListResponseDto responseBody = new GetTravelListResponseDto(travels);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
