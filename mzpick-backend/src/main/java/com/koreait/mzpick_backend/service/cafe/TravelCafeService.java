package com.koreait.mzpick_backend.service.cafe;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.cafe.PatchTravelCafeRequestDto;
import com.koreait.mzpick_backend.dto.request.cafe.PostTravelCafeRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.cafe.GetTravelCafeDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.cafe.GetTravelCafeListResponseDto;

//service 여행지 서비스 //
public interface TravelCafeService {
    ResponseEntity<? super GetTravelCafeListResponseDto> getTravelCafeList(Integer page);

    ResponseEntity<? super GetTravelCafeDetailResponseDto> getTravelCafe(Integer travelNumber);

    ResponseEntity<ResponseDto> postTravelCafe(PostTravelCafeRequestDto dto, String userId);

    ResponseEntity<ResponseDto> patchTravelCafe(PatchTravelCafeRequestDto dto, Integer travelNumber, String userId);

    ResponseEntity<ResponseDto> deleteTravelCafe(Integer travelNumber, String userId);

    ResponseEntity<ResponseDto> upTravelCafeViewCount(Integer travelNumber);

}
