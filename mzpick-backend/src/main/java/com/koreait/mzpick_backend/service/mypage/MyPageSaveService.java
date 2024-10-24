package com.koreait.mzpick_backend.service.mypage;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface MyPageSaveService {
    
    ResponseEntity<ResponseDto> userSaveTravel();
    ResponseEntity<ResponseDto> userSaveFood();
    ResponseEntity<ResponseDto> userSaveStay();
    ResponseEntity<ResponseDto> userSaveFashion();
}
