package com.koreait.mzpick_backend.service.stay;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.travel.PostTravelCommentRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface  TravelStayCommentService {
    
    ResponseEntity<ResponseDto> getComment(Integer travelStayNumber);
    ResponseEntity<ResponseDto> postComment(PostTravelCommentRequestDto dto, String userId);
    ResponseEntity<ResponseDto> deletecomment(Integer travelStayCommentNumber);
}
