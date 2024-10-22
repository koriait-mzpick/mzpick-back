package com.koreait.mzpick_backend.service.travel;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.travel.PostTravelCommentRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface TravelCommentService {
    // ResponseEntity<ResponseDto> getComment(Integer travelNumber);

    ResponseEntity<ResponseDto> postTravelComment(PostTravelCommentRequestDto dto, Integer travelNumber, String userId);

    ResponseEntity<ResponseDto> deleteTravelComment(Integer travelCommentNumber, String userId);
}
