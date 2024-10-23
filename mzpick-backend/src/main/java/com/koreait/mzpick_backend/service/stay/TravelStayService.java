package com.koreait.mzpick_backend.service.stay;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.stay.PatchTravelStayRequestDto;
import com.koreait.mzpick_backend.dto.request.stay.PostTravelStayRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.stay.GetTravelStayDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.stay.GetTravelStayListResponseDto;

//service 여행지 서비스 //
public interface TravelStayService {
    ResponseEntity<? super GetTravelStayListResponseDto> getTravelStayList(Integer page);

    ResponseEntity<? super GetTravelStayDetailResponseDto> getTravelStay(Integer travelNumber);

    ResponseEntity<ResponseDto> postTravelStay(PostTravelStayRequestDto dto, String userId);

    ResponseEntity<ResponseDto> patchTravelStay(PatchTravelStayRequestDto dto, Integer travelNumber, String userId);

    ResponseEntity<ResponseDto> deleteTravelStay(Integer travelNumber, String userId);

    ResponseEntity<ResponseDto> upTravelStayViewCount(Integer travelNumber);

}
