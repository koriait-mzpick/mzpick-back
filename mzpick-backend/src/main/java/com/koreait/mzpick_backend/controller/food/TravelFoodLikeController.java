package com.koreait.mzpick_backend.controller.food;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.service.food.TravelFoodLikeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/food/like")
@RequiredArgsConstructor
public class TravelFoodLikeController {

    private final TravelFoodLikeService travelFoodLikeService;
    
    // @GetMapping("/{travelFoodNumber}")
    // public ResponseEntity<ResponseDto> getLike(
    //     @PathVariable("travelFoodNumber")Integer travelFoodNumber
    // ) {
    //     ResponseEntity<ResponseDto> response = travelFoodLikeService.getLike(travelFoodNumber);
    //     return response;
    // }

    // @PostMapping("/{travelFoodNumber}")
    // public ResponseEntity<ResponseDto> postLike(
    //     @RequestBody @Valid String reponseBody,
    //     @PathVariable("travelFoodNumber")Integer travelFoodNumber,
    //     @AuthenticationPrincipal String userId
    // ) {
    //     ResponseEntity<ResponseDto> response = travelFoodLikeService.postLike(travelFoodNumber, userId);
    //     return response;
    // }
}
