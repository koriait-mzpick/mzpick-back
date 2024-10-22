package com.koreait.mzpick_backend.service.fashion;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface FashionSaveService {
    
        ResponseEntity<ResponseDto> postSave(Integer fashionNumber, String userId);

}
