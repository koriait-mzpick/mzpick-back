package com.koreait.mzpick_backend.service.food;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseDto;

//service 여행지 좋아요 서비스 //
public interface TravelFoodLikeService {
    ResponseEntity<ResponseDto> putLike(Integer travelNumber, String userId);
}
