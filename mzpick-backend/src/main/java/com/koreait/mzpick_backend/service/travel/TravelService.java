package com.koreait.mzpick_backend.service.travel;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface  TravelService {
    ResponseEntity<ResponseDto> travelFavorite(Integer travelNumber, String userId);
}
