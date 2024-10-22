package com.koreait.mzpick_backend.service.travel;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface TravelSaveService {
    ResponseEntity<ResponseDto> putSave(Integer travelNumber, String userId);
}
