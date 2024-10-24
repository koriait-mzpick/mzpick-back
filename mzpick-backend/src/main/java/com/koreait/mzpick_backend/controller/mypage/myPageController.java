package com.koreait.mzpick_backend.controller.mypage;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.mypage.MyPageBoardReadService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class MyPageController {
    
    private final MyPageBoardReadService myPageBoardReadService;

    @GetMapping("write-travel")
    public ResponseEntity<ResponseDto> userBoardReadTravel() {
        ResponseEntity<ResponseDto> response = myPageBoardReadService.userBoardReadTravel();
        return response;
    }
    @GetMapping("write-food")
    public ResponseEntity<ResponseDto> userBoardReadFood() {
        ResponseEntity<ResponseDto> response = myPageBoardReadService.userBoardReadFood();
        return response;
    }
    @GetMapping("write-stay")
    public ResponseEntity<ResponseDto> userBoardReadStay() {
        ResponseEntity<ResponseDto> response = myPageBoardReadService.userBoardReadStay();
        return response;
    }
    @GetMapping("write-fashion")
    public ResponseEntity<ResponseDto> userBoardReadFashion() {
        ResponseEntity<ResponseDto> response = myPageBoardReadService.userBoardReadFashion();
        return response;
    }
    @DeleteMapping("/")
    public ResponseEntity<ResponseDto> userDelete(
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = myPageBoardReadService.userDelete(userId);
        return response;
    }
}
