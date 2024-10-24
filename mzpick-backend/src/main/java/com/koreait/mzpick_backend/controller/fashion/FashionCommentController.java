package com.koreait.mzpick_backend.controller.fashion;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.request.fashion.PostFashionCommentRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.fashion.GetFashionCommentListResponseDto;
import com.koreait.mzpick_backend.service.fashion.FashionCommentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/fashion/comment")
@RequiredArgsConstructor
public class FashionCommentController {

    private final FashionCommentService fashionCommentService;

    @GetMapping("/{fashionNumber}")
    public ResponseEntity<? super GetFashionCommentListResponseDto> getFashionComment(
            @PathVariable("fashionNumber") Integer fashionNumber) {
        ResponseEntity<? super GetFashionCommentListResponseDto> response = fashionCommentService.getFashionCommentList(fashionNumber);
        return response;
    }

    @PostMapping("/{fashionNumber}")
    public ResponseEntity<ResponseDto> postFashionComment(
            @RequestBody @Valid PostFashionCommentRequestDto requestBody,
            @PathVariable("fashionNumber") Integer fashionNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = fashionCommentService.postFashionComment(requestBody, fashionNumber, userId);
        return response;
    }

    @DeleteMapping("/{fashionCommentNumber}")
    public ResponseEntity<ResponseDto> deleteComment(
            @PathVariable("fashionCommentNumber") Integer fashionCommentNumber,
            @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = fashionCommentService.deleteFashionComment(fashionCommentNumber, userId);
        return response;
    }
}
