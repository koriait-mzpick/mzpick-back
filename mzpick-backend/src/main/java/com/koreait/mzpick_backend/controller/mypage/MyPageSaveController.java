package com.koreait.mzpick_backend.controller.mypage;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.mypage.MyPageSaveService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class MyPageSaveController {
    
    private final MyPageSaveService myPageSaveService;

    @GetMapping("/save-travel")
    public ResponseEntity<ResponseDto> userLikeTravel() {
        ResponseEntity<ResponseDto> response = myPageSaveService.userSaveTravel();
        return response;
    }
    @GetMapping("/save-food")
    public ResponseEntity<ResponseDto> userLikeFood() {
        ResponseEntity<ResponseDto> response = myPageSaveService.userSaveFood();
        return response;
    }
    @GetMapping("/save-stay")
    public ResponseEntity<ResponseDto> userLikeStay() {
        ResponseEntity<ResponseDto> response = myPageSaveService.userSaveStay();
        return response;
    }
    @GetMapping("/save-fashion")
    public ResponseEntity<ResponseDto> userLikeFashion() {
        ResponseEntity<ResponseDto> response = myPageSaveService.userSaveFashion();
        return response;
    }
}
