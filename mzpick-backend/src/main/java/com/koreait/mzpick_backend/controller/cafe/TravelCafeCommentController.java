package com.koreait.mzpick_backend.controller.cafe;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.request.cafe.PostTravelCafeCommentRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.cafe.GetTravelCafeCommentListResponseDto;
import com.koreait.mzpick_backend.service.cafe.TravelCafeCommentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/cafe/comment")
@RequiredArgsConstructor
public class TravelCafeCommentController {
    
    private final TravelCafeCommentService travelCafeCommentService;

    @GetMapping("/{travelCafeNumber}")
    public ResponseEntity<? super GetTravelCafeCommentListResponseDto> getTravelCafeCommentList(
        @PathVariable("travelCafeNumber")Integer travelCafeNumber
    ) {
        ResponseEntity<? super GetTravelCafeCommentListResponseDto> response = travelCafeCommentService.getTravelCafeCommentList(travelCafeNumber);
        return response;
    }
    
    // controller 해당 게시판 여행 댓글 입력하기 //
    @PostMapping("/{travelCafeNumber}")
    public ResponseEntity<ResponseDto> postCommentCafe(
        @RequestBody @Valid PostTravelCafeCommentRequestDto requestBody,
        @PathVariable("travelCafeNumber") Integer travelCafeNumber,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = travelCafeCommentService.postTravelCafeComment(requestBody, travelCafeNumber, userId);
        return response;
    }

    // controller 해당 게시판 여행 댓글 삭제하기 //
    @DeleteMapping("/{travelCafeCommentNumber}")
    public ResponseEntity<ResponseDto> deleteCommentCafe(
        @PathVariable("travelCafeCommentNumber") Integer travelCafeCommentNumber,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = travelCafeCommentService.deleteTravelCafeComment(travelCafeCommentNumber, userId);
        return response;
    }
}
