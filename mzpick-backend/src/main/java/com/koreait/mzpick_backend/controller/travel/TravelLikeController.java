package com.koreait.mzpick_backend.controller.travel;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.travel.TravelLikeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/travel/like")
@RequiredArgsConstructor
public class TravelLikeController {

    private final TravelLikeService travelLikeService;

    // @GetMapping("/{travelNumber}")
    // public ResponseEntity<ResponseDto> getLike() {
        

    //     ResponseEntity<ResponseDto> response = travelLikeService.getLike();
    //     return response;
    // }
    @PutMapping("/{travelNumber}")
    public ResponseEntity<ResponseDto> postLike(
        @PathVariable("travelNumber") Integer travelNumber,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = travelLikeService.postLike(travelNumber, userId);
        return response;
    }
}
