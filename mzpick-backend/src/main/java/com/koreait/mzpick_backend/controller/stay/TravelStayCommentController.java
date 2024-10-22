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

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.stay.TravelStayCommentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/stay/comment")
@RequiredArgsConstructor
public class TravelStayCommentController {
    
    private final TravelStayCommentService travelStayCommentService;

    @GetMapping("/{travelStayNumber}")
    public ResponseEntity<ResponseDto> getComment(
        @PathVariable("travelStayNumber") Integer travelStayNumber
    ) {
        ResponseEntity<ResponseDto> response = travelStayCommentService.getComment(travelStayNumber);
        return response;
    }

    @PostMapping("/{travelStayNumber}")
    public ResponseEntity<ResponseDto> postComment(
        @RequestBody @Valid String requestBody,
        @PathVariable("travelStayNumber") Integer travelStayNumber,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = travelStayCommentService.getComment(travelStayNumber);
        return response;
    }

    @DeleteMapping("/{travelStaycommentNumber}")
    public ResponseEntity<ResponseDto> deleteComment(
        @PathVariable("travelStaycommentNumber") Integer travelStayCommentNumber,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = travelStayCommentService.deletecomment(travelStayCommentNumber);
        return response;
    }

}
