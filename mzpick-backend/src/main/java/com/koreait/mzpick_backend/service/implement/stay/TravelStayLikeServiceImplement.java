package com.koreait.mzpick_backend.service.implement.stay;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.stay.TravelStayLikeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelStayLikeServiceImplement implements TravelStayLikeService {@Override
    public ResponseEntity<ResponseDto> getLIke(Integer travelStayNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLIke'");
    }

    @Override
    public ResponseEntity<ResponseDto> postLIke(String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postLIke'");
    }
    
}
