package com.koreait.mzpick_backend.service.mypage;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface MyPageService {
    
    ResponseEntity<ResponseDto> userDelete(String userId);
    ResponseEntity<ResponseDto> userBoardRead();
    ResponseEntity<ResponseDto> userLikeBoardRead();
    ResponseEntity<ResponseDto> userSaveBoardRead();
    ResponseEntity<ResponseDto> userPostVoteRead();
}
