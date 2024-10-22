package com.koreait.mzpick_backend.service.stay;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface TravelStayLikeService {
    
    ResponseEntity<ResponseDto> getLIke(Integer travelStayNumber);
    ResponseEntity<ResponseDto> postLIke(String userId);
    
}
