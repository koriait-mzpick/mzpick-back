package com.koreait.mzpick_backend.service.travel;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseDto;

//service 여행지 저장 서비스 //
public interface TravelSaveService {
    ResponseEntity<ResponseDto> putSave(Integer travelNumber, String userId);
}
