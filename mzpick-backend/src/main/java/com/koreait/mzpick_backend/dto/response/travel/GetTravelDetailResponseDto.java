package com.koreait.mzpick_backend.dto.response.travel;
// 여행지 리스트 보기 요청 dto

import com.koreait.mzpick_backend.dto.response.ResponseDto;

import lombok.Getter;

@Getter

public class GetTravelDetailResponseDto extends ResponseDto{

    public GetTravelDetailResponseDto(String code, String message) {
        super(code, message);
        //TODO Auto-generated constructor stub
    }
    
}
