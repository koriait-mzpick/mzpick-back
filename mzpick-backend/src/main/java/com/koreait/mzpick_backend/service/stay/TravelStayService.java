package com.koreait.mzpick_backend.service.stay;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.stay.PatchTravelStayRequestDto;
import com.koreait.mzpick_backend.dto.request.stay.PostTravelStayRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface TravelStayService {
    ResponseEntity<ResponseDto> postTravelStay(PostTravelStayRequestDto dto, String userId);

    ResponseEntity<ResponseDto> patchTravelStay(PatchTravelStayRequestDto dto, Integer travelStayNumber, String userId);

    ResponseEntity<ResponseDto> deleteTravelStay(Integer travelStayNumber, String userId);
}
