package com.koreait.mzpick_backend.service.mypage;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface MyPageVoteService {
    
    ResponseEntity<ResponseDto> userVoteTravel();
    ResponseEntity<ResponseDto> userVoteFood();
    ResponseEntity<ResponseDto> userVoteStay();
    ResponseEntity<ResponseDto> userVoteFashion();
}
