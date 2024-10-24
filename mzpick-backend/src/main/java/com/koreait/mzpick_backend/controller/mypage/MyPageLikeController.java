package com.koreait.mzpick_backend.controller.mypage;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.mypage.MyPageLikeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class MyPageLikeController {
    
    private final MyPageLikeService myPageLikeService;

    @GetMapping("/like-travel")
    public ResponseEntity<ResponseDto> userLikeTravel() {
        ResponseEntity<ResponseDto> response = myPageLikeService.userLikeTravel();
        return response;
    }
    @GetMapping("/like-food")
    public ResponseEntity<ResponseDto> userLikeFood() {
        ResponseEntity<ResponseDto> response = myPageLikeService.userLikeFood();
        return response;
    }
    @GetMapping("/like-stay")
    public ResponseEntity<ResponseDto> userLikeStay() {
        ResponseEntity<ResponseDto> response = myPageLikeService.userLikeStay();
        return response;
    }
    @GetMapping("/like-fashion")
    public ResponseEntity<ResponseDto> userLikeFashion() {
        ResponseEntity<ResponseDto> response = myPageLikeService.userLikeFashion();
        return response;
    }
}
