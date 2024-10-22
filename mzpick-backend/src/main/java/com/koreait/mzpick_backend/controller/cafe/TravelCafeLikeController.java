package com.koreait.mzpick_backend.controller.cafe;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.service.cafe.TravelCafeLikeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/cafe/like")
@RequiredArgsConstructor
public class TravelCafeLikeController {
    
    private final TravelCafeLikeService travelCafeLikeService;

    // @PutMapping("/{travelCafeNumber}")
    // public ResponseEntity<ResponseDto> putLike(
    //     @PathVariable("travelCafeNumber") Integer travelCafeNumber,
    //     @AuthenticationPrincipal String userId
    // ) {
    //     ResponseEntity<ResponseDto> response = travelCafeLikeService.putLike(travelCafeNumber, userId);
    //     return response;
    // }
}
