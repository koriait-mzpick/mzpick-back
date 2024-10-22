package com.koreait.mzpick_backend.service.food;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface TravelFoodSaveService {
    
    ResponseEntity<ResponseDto> postSave(Integer travelFoodNumber, String userId);
}
