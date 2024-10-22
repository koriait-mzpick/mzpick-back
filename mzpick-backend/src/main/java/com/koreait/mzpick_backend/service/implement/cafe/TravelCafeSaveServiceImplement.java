package com.koreait.mzpick_backend.service.implement.cafe;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.cafe.TravelCafeSaveService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelCafeSaveServiceImplement implements TravelCafeSaveService{@Override
    public ResponseEntity<ResponseDto> postSave(Integer travelCafeNumber, String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postSave'");
    }
    
}
