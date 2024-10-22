package com.koreait.mzpick_backend.service.food;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.food.PatchTravelFoodRequestDto;
import com.koreait.mzpick_backend.dto.request.food.PostTravelFoodRequestDto;

import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface TravelFoodService {
    ResponseEntity<ResponseDto> getTravelFood();
    ResponseEntity<ResponseDto> getTravelFoodNum(Integer travelFoodNumber);
    ResponseEntity<ResponseDto> postTravelFood(PostTravelFoodRequestDto dto, String userId);

    ResponseEntity<ResponseDto> patchTravelFood(PatchTravelFoodRequestDto dto, Integer travelFoodNumber, String userId);

    ResponseEntity<ResponseDto> deleteTravelFood(Integer travelFoodNumber, String userId);
}
