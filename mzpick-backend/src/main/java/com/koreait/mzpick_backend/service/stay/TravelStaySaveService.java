package com.koreait.mzpick_backend.service.stay;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface TravelStaySaveService {
    
    ResponseEntity<ResponseDto> postSave(Integer travelStayNumber, String userId);
}
