package com.koreait.mzpick_backend.service.cafe;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface TravelCafeSaveService {
    
        ResponseEntity<ResponseDto> postSave(Integer travelCafeNumber, String userId);

}
