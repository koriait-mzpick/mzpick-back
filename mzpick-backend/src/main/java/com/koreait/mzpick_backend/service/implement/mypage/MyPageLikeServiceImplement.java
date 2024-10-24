package com.koreait.mzpick_backend.service.implement.mypage;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.mypage.MyPageLikeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyPageLikeServiceImplement implements MyPageLikeService {
    @Override
    public ResponseEntity<ResponseDto> userLikeTravel() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'userLikeTravel'");
    }

    @Override
    public ResponseEntity<ResponseDto> userLikeFood() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'userLikeFood'");
    }

    @Override
    public ResponseEntity<ResponseDto> userLikeStay() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'userLikeStay'");
    }

    @Override
    public ResponseEntity<ResponseDto> userLikeFashion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'userLikeFashion'");
    }
    
}
