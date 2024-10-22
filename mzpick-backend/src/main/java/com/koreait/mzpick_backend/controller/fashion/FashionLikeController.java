package com.koreait.mzpick_backend.controller.fashion;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.service.cafe.TravelCafeLikeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/fashion/like")
@RequiredArgsConstructor
public class FashionLikeController {
    
    private final TravelCafeLikeService travelCafeLikeService;

    // @GetMapping("/{travelCafeNumber}")
    // public ResponseEntity<ResponseDto> getLike(
    //     @PathVariable("travelCafeNumber")Integer travelCafeNumber
    // ) {
    //     ResponseEntity<ResponseDto> response = travelCafeLikeService.getLike(travelCafeNumber);
    //     return response;
    // }

    // @PostMapping("/{travelCafeNumber}")
    // public ResponseEntity<ResponseDto> postLike(
    //     @RequestBody @Valid String requestBody,
    //     @PathVariable("travelCafeNumber")Integer travelCafeNumber,
    //     @AuthenticationPrincipal String userid
    // ) {
    //     ResponseEntity<ResponseDto> response = travelCafeLikeService.getLike(travelCafeNumber);
    //     return response;
    // }
}
