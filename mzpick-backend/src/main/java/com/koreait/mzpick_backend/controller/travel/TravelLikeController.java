package com.koreait.mzpick_backend.controller.travel;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/travel/like")
@RequiredArgsConstructor
public class TravelLikeController {

    // private final TravelLikeService travelLikeService;

    // @GetMapping("/{travelNumber}")
    // public ResponseEntity<ResponseDto> getLike() {
        

    //     ResponseEntity<ResponseDto> response = travelLikeService.getLike();
    //     return response;
    // }
    // @GetMapping("/{travelNumber}")
    // public ResponseEntity<ResponseDto> postLike(
    //     @RequestBody @Valid Integer travelNumber
    // ) {
        

    //     ResponseEntity<ResponseDto> response = travelLikeService.postLike();
    //     return response;
    // }

}
