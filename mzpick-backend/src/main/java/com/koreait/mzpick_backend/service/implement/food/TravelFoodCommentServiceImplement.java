package com.koreait.mzpick_backend.service.implement.food;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.food.TravelFoodCommentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelFoodCommentServiceImplement implements TravelFoodCommentService{@Override
    public ResponseEntity<ResponseDto> getComment(Integer travelFoodNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getComment'");
    }

    @Override
    public ResponseEntity<ResponseDto> postComment(Integer travelFoodNumber, String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postComment'");
    }

    @Override
    public ResponseEntity<ResponseDto> deleteComment(Integer travelFoodCommentNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteComment'");
    }
    
}


