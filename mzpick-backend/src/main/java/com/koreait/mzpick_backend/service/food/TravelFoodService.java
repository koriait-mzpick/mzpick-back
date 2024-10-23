package com.koreait.mzpick_backend.service.food;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.food.PatchTravelFoodRequestDto;
import com.koreait.mzpick_backend.dto.request.food.PostTravelFoodRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.food.GetTravelFoodDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.food.GetTravelFoodListResponseDto;

//service 여행지 서비스 //
public interface TravelFoodService {
    ResponseEntity<? super GetTravelFoodListResponseDto> getTravelFoodList(Integer page);

    ResponseEntity<? super GetTravelFoodDetailResponseDto> getTravelFood(Integer travelNumber);

    ResponseEntity<ResponseDto> postTravelFood(PostTravelFoodRequestDto dto, String userId);

    ResponseEntity<ResponseDto> patchTravelFood(PatchTravelFoodRequestDto dto, Integer travelNumber, String userId);

    ResponseEntity<ResponseDto> deleteTravelFood(Integer travelNumber, String userId);

    ResponseEntity<ResponseDto> upTravelFoodViewCount(Integer travelNumber);

}
