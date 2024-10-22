package com.koreait.mzpick_backend.service.implement.food;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.food.TravelFoodLikeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelFoodLikeServiceImplement implements TravelFoodLikeService {@Override
    public ResponseEntity<ResponseDto> getLike(Integer travelFoodNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLike'");
    }

    @Override
    public ResponseEntity<ResponseDto> postLike(Integer travelFoodNumber, String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postLike'");
    }
    
}
