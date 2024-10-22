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

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.travel.TravelCommentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/travel/comment")
@RequiredArgsConstructor
public class TravelCommentController {
    
    private final TravelCommentService travelCommentService;


    @GetMapping("/{travelNumber}")
    public ResponseEntity<ResponseDto> getComment(
        @PathVariable("travelNumber")Integer travelNumber
    ) {
        ResponseEntity<ResponseDto> response = travelCommentService.getComment(travelNumber);
        return response;
    }
    @PostMapping("/{travelNumber}")
    public ResponseEntity<ResponseDto> postComment(
        @RequestBody @Valid String requestBody,
        @PathVariable("travelNumber")Integer travelNumber,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = travelCommentService.postComment(null, userId);
        return response;
    }
    @DeleteMapping("/{travelCommentNumber}")
    public ResponseEntity<ResponseDto> deleteComment(
        @PathVariable("travelCommentNumber")Integer travelCommentNumber
    ) {
        ResponseEntity<ResponseDto> response = travelCommentService.deletecomment(travelCommentNumber);
        return response;
    }
}
