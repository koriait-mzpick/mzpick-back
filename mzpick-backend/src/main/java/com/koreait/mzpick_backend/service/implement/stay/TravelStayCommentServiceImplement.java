package com.koreait.mzpick_backend.service.implement.stay;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.request.travel.PostTravelCommentRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.stay.TravelStayCommentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelStayCommentServiceImplement implements TravelStayCommentService{@Override
    public ResponseEntity<ResponseDto> getComment(Integer travelStayNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getComment'");
    }

@Override
public ResponseEntity<ResponseDto> postComment(PostTravelCommentRequestDto dto, String userId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'postComment'");
}

@Override
public ResponseEntity<ResponseDto> deletecomment(Integer travelStayCommentNumber) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deletecomment'");
}
    
}


