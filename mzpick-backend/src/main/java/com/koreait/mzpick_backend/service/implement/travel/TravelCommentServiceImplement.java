package com.koreait.mzpick_backend.service.implement.travel;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.travel.PostTravelCommentRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.travel.TravelCommentService;

public class TravelCommentServiceImplement implements TravelCommentService {

    @Override
    public ResponseEntity<ResponseDto> getComment(Integer travelNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getComment'");
    }

    @Override
    public ResponseEntity<ResponseDto> postComment(PostTravelCommentRequestDto dto, String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postComment'");
    }

    @Override
    public ResponseEntity<ResponseDto> deletecomment(Integer travelCommentNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletecomment'");
    }
    
}


