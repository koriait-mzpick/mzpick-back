package com.koreait.mzpick_backend.service.implement.cafe;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.cafe.TravelCafeLikeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelCafeLikeServiceImplement implements TravelCafeLikeService {@Override
    public ResponseEntity<ResponseDto> getLike(Integer travelCafeNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLike'");
    }

    @Override
    public ResponseEntity<ResponseDto> postLike(Integer travelCafeNumber, String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postLike'");
    }

    
}