package com.koreait.mzpick_backend.service.cafe;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseDto;

//service 여행지 저장 서비스 //
public interface TravelCafeSaveService {
    ResponseEntity<ResponseDto> putSave(Integer travelNumber, String userId);
}
