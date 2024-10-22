package com.koreait.mzpick_backend.service.implement.fashion;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.fashion.FashionLikeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FashionLikeServiceImplement implements FashionLikeService {
    @Override
    public ResponseEntity<ResponseDto> getLike(Integer fashionNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLike'");
    }

    @Override
    public ResponseEntity<ResponseDto> postLike(Integer fashionNumber, String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postLike'");
    }

    
}