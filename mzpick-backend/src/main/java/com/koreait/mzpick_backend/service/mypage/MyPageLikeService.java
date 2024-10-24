package com.koreait.mzpick_backend.service.mypage;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface MyPageLikeService {
    
    ResponseEntity<ResponseDto> userLikeTravel();
    ResponseEntity<ResponseDto> userLikeFood();
    ResponseEntity<ResponseDto> userLikeStay();
    ResponseEntity<ResponseDto> userLikeFashion();
}
