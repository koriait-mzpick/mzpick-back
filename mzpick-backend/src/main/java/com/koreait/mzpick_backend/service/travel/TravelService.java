package com.koreait.mzpick_backend.service.travel;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.travel.PatchTravelRequestDto;
import com.koreait.mzpick_backend.dto.request.travel.PostTravelRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface  TravelService {
    ResponseEntity<ResponseDto> postTravel(PostTravelRequestDto dto, String userId);
    ResponseEntity<ResponseDto> patchTravel(PatchTravelRequestDto dto, Integer travelNumber, String userId);
    ResponseEntity<ResponseDto> deleteTravel(Integer travelNumber, String userId);

}
