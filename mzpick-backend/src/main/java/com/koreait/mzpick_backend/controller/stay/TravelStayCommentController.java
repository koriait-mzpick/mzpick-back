package com.koreait.mzpick_backend.controller.stay;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.request.stay.PostTravelStayCommentRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.stay.GetTravelStayCommentListResponseDto;
import com.koreait.mzpick_backend.service.stay.TravelStayCommentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/stay/comment")
@RequiredArgsConstructor
public class TravelStayCommentController {
    
    private final TravelStayCommentService travelStayCommentService;

    @GetMapping("/{travelStayNumber}")
    public ResponseEntity<? super GetTravelStayCommentListResponseDto> getTravelStayCommentList(
        @PathVariable("travelStayNumber")Integer travelStayNumber
    ) {
        ResponseEntity<? super GetTravelStayCommentListResponseDto> response = travelStayCommentService.getTravelStayCommentList(travelStayNumber);
        return response;
    }
    
    // controller 해당 게시판 여행 댓글 입력하기 //
    @PostMapping("/{travelStayNumber}")
    public ResponseEntity<ResponseDto> postCommentStay(
        @RequestBody @Valid PostTravelStayCommentRequestDto requestBody,
        @PathVariable("travelStayNumber") Integer travelStayNumber,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = travelStayCommentService.postTravelStayComment(requestBody, travelStayNumber, userId);
        return response;
    }

    // controller 해당 게시판 여행 댓글 삭제하기 //
    @DeleteMapping("/{travelStayCommentNumber}")
    public ResponseEntity<ResponseDto> deleteCommentStay(
        @PathVariable("travelStayCommentNumber") Integer travelStayCommentNumber,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = travelStayCommentService.deleteTravelStayComment(travelStayCommentNumber, userId);
        return response;
    }
}
