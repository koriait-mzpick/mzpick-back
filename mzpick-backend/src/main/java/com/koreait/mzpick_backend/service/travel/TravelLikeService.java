package com.koreait.mzpick_backend.service.travel;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface TravelLikeService {
    ResponseEntity<ResponseDto> getLike(Integer travelNumber);
    ResponseEntity<ResponseDto> postLike(String userId);
}
