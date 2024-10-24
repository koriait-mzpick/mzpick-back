package com.koreait.mzpick_backend.service.mypage;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface MyPageBoardReadService {
    
    ResponseEntity<ResponseDto> userDelete(String userId);
    ResponseEntity<ResponseDto> userBoardReadTravel();
    ResponseEntity<ResponseDto> userBoardReadFood();
    ResponseEntity<ResponseDto> userBoardReadStay();
    ResponseEntity<ResponseDto> userBoardReadFashion();
}
