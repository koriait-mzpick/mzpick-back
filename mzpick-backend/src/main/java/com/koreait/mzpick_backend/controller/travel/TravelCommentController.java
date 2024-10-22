package com.koreait.mzpick_backend.controller.travel;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.request.travel.PostTravelCommentRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.travel.GetTravelCommentListResponseDto;
import com.koreait.mzpick_backend.service.travel.TravelCommentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/travel/comment")
@RequiredArgsConstructor
public class TravelCommentController {

    private final TravelCommentService travelCommentService;

    // controller 해당 게시판 여행 댓글 리스트 불러오기 //
    @GetMapping("/{travelNumber}")
    public ResponseEntity<? super GetTravelCommentListResponseDto> getTravelCommentList(
        @PathVariable("travelNumber")Integer travelNumber
    ) {
        ResponseEntity<? super GetTravelCommentListResponseDto> response = travelCommentService.getTravelCommentList(travelNumber);
        return response;
    }
    
    // controller 해당 게시판 여행 댓글 입력하기 //
    @PostMapping("/{travelNumber}")
    public ResponseEntity<ResponseDto> postComment(
        @RequestBody @Valid PostTravelCommentRequestDto requestBody,
        @PathVariable("travelNumber") Integer travelNumber,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = travelCommentService.postTravelComment(requestBody, travelNumber, userId);
        return response;
    }

    // controller 해당 게시판 여행 댓글 삭제하기 //
    @DeleteMapping("/{travelCommentNumber}")
    public ResponseEntity<ResponseDto> deleteComment(
        @PathVariable("travelCommentNumber") Integer travelCommentNumber,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = travelCommentService.deleteTravelComment(travelCommentNumber, userId);
        return response;
    }
}
