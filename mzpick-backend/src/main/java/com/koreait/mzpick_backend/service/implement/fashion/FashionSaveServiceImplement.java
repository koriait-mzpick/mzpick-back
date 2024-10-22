package com.koreait.mzpick_backend.service.implement.fashion;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.fashion.FashionSaveService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FashionSaveServiceImplement implements FashionSaveService{
    @Override
    public ResponseEntity<ResponseDto> postSave(Integer fashionNumber, String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postSave'");
    }
    
}
