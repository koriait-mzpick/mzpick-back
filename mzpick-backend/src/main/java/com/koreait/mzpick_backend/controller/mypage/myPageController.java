package com.koreait.mzpick_backend.controller.mypage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.service.mypage.MyPageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class myPageController {
    
    private final MyPageService myPageService;

    // @GetMapping("write")
    // public ResponseEntity<ResponseDto> userBoardRead() {
    //     ResponseEntity<ResponseDto> response = myPageService.userBoardRead();
    //     return response;
    // }
    // @GetMapping("like")
    // public ResponseEntity<ResponseDto> userLikeBoardRead() {
    //     ResponseEntity<ResponseDto> response = myPageService.userLikeBoardRead();
    //     return response;
    // }
    // @GetMapping("save")
    // public ResponseEntity<ResponseDto> userSaveBoardRead() {
    //     ResponseEntity<ResponseDto> response = myPageService.userSaveBoardRead();
    //     return response;
    // }
    // @GetMapping("vote")
    // public ResponseEntity<ResponseDto> userPostBoardRead() {
    //     ResponseEntity<ResponseDto> response = myPageService.userPostVoteRead();
    //     return response;
    // }
    // @DeleteMapping("/{userId}")
    // public ResponseEntity<ResponseDto> userDelete(
    //     @PathVariable("userId")String userId
    // ) {
    //     ResponseEntity<ResponseDto> response = myPageService.userDelete(userId);
    //     return response;
    // }
}
