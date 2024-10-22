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

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.cafe.TravelCafeCommentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/cafe/comment")
@RequiredArgsConstructor
public class TravelCafeCommentController {
    
    private final TravelCafeCommentService travelCafeCommentService;

    @GetMapping("/{travelCafeNumber}")
    public ResponseEntity<ResponseDto> getComment(
        @PathVariable("travelCafeNumber")Integer travelCafeNumber
    ) {
        ResponseEntity<ResponseDto> response = travelCafeCommentService.getComment(travelCafeNumber);
        return response;
    }
    @PostMapping("/{travelCafeNumber}")
    public ResponseEntity<ResponseDto> postComment(
        @RequestBody @Valid String requestBody,
        @PathVariable("travelCafeNumber")Integer travelCafeNumber,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = travelCafeCommentService.postComment(travelCafeNumber, userId);
        return response;
    }
    @DeleteMapping("/{travelCafeNumber}")
    public ResponseEntity<ResponseDto> deleteComment(
        @PathVariable("travelCafeNumber")Integer travelCafeNumber
    ) {
        ResponseEntity<ResponseDto> response = travelCafeCommentService.deleteComment(travelCafeNumber);
        return response;
    }
}
