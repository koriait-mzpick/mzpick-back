package com.koreait.mzpick_backend.service.food;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface TravelFoodLikeService {
    
    ResponseEntity<ResponseDto> getLike(Integer travelFoodNumber);
    ResponseEntity<ResponseDto> postLike(Integer travelFoodNumber, String userId);
    
}
