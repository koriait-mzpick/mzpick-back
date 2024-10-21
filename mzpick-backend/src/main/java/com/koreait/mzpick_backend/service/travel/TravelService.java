package com.koreait.mzpick_backend.service.travel;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.koreait.mzpick_backend.dto.request.travel.PatchTravelRequestDto;
import com.koreait.mzpick_backend.dto.request.travel.PostTravelRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface  TravelService {
    ResponseEntity<ResponseDto> postTravel(PostTravelRequestDto dto, String userId);
    ResponseEntity<ResponseDto> patchTravel(PatchTravelRequestDto dto, Integer travelNumber, String userID);
    ResponseEntity<ResponseDto> deleteTravel(Integer travelNumber, String userId);

}
