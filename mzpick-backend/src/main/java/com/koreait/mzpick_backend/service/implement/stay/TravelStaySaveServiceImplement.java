package com.koreait.mzpick_backend.service.implement.stay;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.stay.TravelStaySaveService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelStaySaveServiceImplement implements TravelStaySaveService {@Override
    public ResponseEntity<ResponseDto> postSave(Integer travelStayNumber, String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postSave'");
    }
    
}
