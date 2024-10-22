package com.koreait.mzpick_backend.controller.food;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.food.TravelFoodCommentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/food/comment")
@RequiredArgsConstructor
public class TravelFoodCommentController {
    
    private final TravelFoodCommentService travelFoodCommentService;

    @GetMapping("/{travelFoodNumber}")
    public ResponseEntity<ResponseDto> getComment(
        @PathVariable("travelFoodNumber")Integer travelFoodNumber
    ) {
        ResponseEntity<ResponseDto> response = travelFoodCommentService.getComment(travelFoodNumber);
        return response;
    }

    @PostMapping("/{travelFoodNumber}")
    public ResponseEntity<ResponseDto> postComment(
        @PathVariable("travelFoodNumber")Integer travelFoodNumber,
        @RequestBody @Valid String reponseBody,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = travelFoodCommentService.postComment(travelFoodNumber, userId);
        return response;
    }
    @GetMapping("/{travelFoodNumber}")
    public ResponseEntity<ResponseDto> deleteComment(
        @PathVariable("travelFoodNumber")Integer travelFoodNumber
    ) {
        ResponseEntity<ResponseDto> response = travelFoodCommentService.deleteComment(travelFoodNumber);
        return response;
    }
    
}
