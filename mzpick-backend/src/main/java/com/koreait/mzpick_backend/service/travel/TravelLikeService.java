package com.koreait.mzpick_backend.service.travel;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface TravelLikeService {
    // ResponseEntity<> getlikeList(Integer TravelNumber);
    ResponseEntity<ResponseDto> postLike(Integer TravelNumber, String userId);
}
