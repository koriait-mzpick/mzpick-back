package com.koreait.mzpick_backend.service.cafe;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.cafe.PatchTravelCafeRequestDto;
import com.koreait.mzpick_backend.dto.request.cafe.PostTravelCafeRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface TravelCafeService {
    ResponseEntity<ResponseDto> postTravelCafe(PostTravelCafeRequestDto dto, String userId);

    ResponseEntity<ResponseDto> patchTravelCafe(PatchTravelCafeRequestDto dto, Integer travelCafeNumber, String userId);

    ResponseEntity<ResponseDto> deleteTravelCafe(Integer travelCafeNumber, String userId);
}
