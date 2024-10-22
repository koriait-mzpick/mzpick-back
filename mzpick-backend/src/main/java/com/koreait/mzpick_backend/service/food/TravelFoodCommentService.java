package com.koreait.mzpick_backend.service.food;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface  TravelFoodCommentService {
    
    ResponseEntity<ResponseDto> getComment(Integer travelFoodNumber);
    ResponseEntity<ResponseDto> postComment(Integer travelFoodNumber, String userId);
    ResponseEntity<ResponseDto> deleteComment(Integer travelFoodCommentNumber);
    
}
