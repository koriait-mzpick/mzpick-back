package com.koreait.mzpick_backend.service.implement.cafe;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.cafe.TravelCafeCommentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelCafeCommentServiceImplement implements TravelCafeCommentService {@Override
    public ResponseEntity<ResponseDto> getComment(Integer travelCafeNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getComment'");
    }

    @Override
    public ResponseEntity<ResponseDto> postComment(Integer travelCafeNumber, String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postComment'");
    }

    @Override
    public ResponseEntity<ResponseDto> deleteComment(Integer travelCafeCommentNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteComment'");
    }
    

}
