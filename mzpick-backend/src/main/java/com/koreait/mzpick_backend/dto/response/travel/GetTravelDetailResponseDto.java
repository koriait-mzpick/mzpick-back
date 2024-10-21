package com.koreait.mzpick_backend.dto.response.travel;
// 여행지 리스트 보기 요청 dto

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.common.object.TravelDetail;
import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetTravelDetailResponseDto extends ResponseDto {

    private TravelDetail travelDetail;

    private GetTravelDetailResponseDto(TravelDetail travelDetail) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.travelDetail = travelDetail;
    }

    public static ResponseEntity<GetTravelDetailResponseDto> success(TravelDetail travelDetail) {
        GetTravelDetailResponseDto responseBody = new GetTravelDetailResponseDto(travelDetail);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
