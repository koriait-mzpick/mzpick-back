package com.koreait.mzpick_backend.controller.mypage;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.mypage.MyPageVoteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class MyPageVoteController {
    
    private final MyPageVoteService myPageVoteService;

    @GetMapping("/vote-travel")
    public ResponseEntity<ResponseDto> userVoteTravel() {
        ResponseEntity<ResponseDto> response = myPageVoteService.userVoteTravel();
        return response;
    }
    @GetMapping("/vote-food")
    public ResponseEntity<ResponseDto> userVoteFood() {
        ResponseEntity<ResponseDto> response = myPageVoteService.userVoteFood();
        return response;
    }
    @GetMapping("/vote-stay")
    public ResponseEntity<ResponseDto> userVoteStay() {
        ResponseEntity<ResponseDto> response = myPageVoteService.userVoteStay();
        return response;
    }
    @GetMapping("/vote-fashion")
    public ResponseEntity<ResponseDto> userVoteFashion() {
        ResponseEntity<ResponseDto> response = myPageVoteService.userVoteFashion();
        return response;
    }
}
