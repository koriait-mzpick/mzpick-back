package com.koreait.mzpick_backend.service.cafe;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface TravelCafeLikeService {
 
    ResponseEntity<ResponseDto> getLike(Integer travelCafeNumber);
    ResponseEntity<ResponseDto> postLike(Integer travelCafeNumber, String userId);
    
}
