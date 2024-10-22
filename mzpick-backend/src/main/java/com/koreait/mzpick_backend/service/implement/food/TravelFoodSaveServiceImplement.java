package com.koreait.mzpick_backend.service.implement.food;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.food.TravelFoodSaveService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelFoodSaveServiceImplement implements TravelFoodSaveService {@Override
    public ResponseEntity<ResponseDto> postSave(Integer travelFoodNumber, String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postSave'");
    }
    
}
