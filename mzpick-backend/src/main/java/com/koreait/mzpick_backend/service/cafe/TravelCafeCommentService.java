package com.koreait.mzpick_backend.service.cafe;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface  TravelCafeCommentService {

    ResponseEntity<ResponseDto> getComment(Integer travelCafeNumber);
    ResponseEntity<ResponseDto> postComment(Integer travelCafeNumber, String userId);
    ResponseEntity<ResponseDto> deleteComment(Integer travelCafeCommentNumber);
    
    
}
