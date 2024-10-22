package com.koreait.mzpick_backend.controller.fashion;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.service.fashion.FashionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/fashion")
@RequiredArgsConstructor
public class FashionController {
    private final FashionService fashionService;

    // @GetMapping(value = { "", "/" })
    // public ResponseEntity<? super GetFasionListResponseDto> getFashion() {
    //     ResponseEntity<? super GetFasionListResponseDto> resposne = fashionService.getFashionList();
    //     return resposne;
    // }

    // @GetMapping("/{fashionNumber}")
    // public ResponseEntity<? super GetFasionDetailResponseDto> getFashion(
    //         @PathVariable("fashionNumber") Integer fashionNumber) {
    //     ResponseEntity<? super GetFasionDetailResponseDto> resposne = fashionService.getFashion(fashionNumber);
    //     return resposne;
    // }

    // @PostMapping(value = { "", "/" })
    // public ResponseEntity<ResponseDto> postFashion(
    //         @RequestBody @Valid PostFashionRequestDto requestBody,
    //         @AuthenticationPrincipal String userId) {
    //     ResponseEntity<ResponseDto> resposne = fashionService.postFashion(requestBody, userId);
    //     return resposne;
    // }

    // @DeleteMapping("/{fashionNumber}")
    // public ResponseEntity<ResponseDto> deleteFashion(
    //         @PathVariable("fashionNumber") Integer fashionNumber,
    //         @AuthenticationPrincipal String userId) {
    //     ResponseEntity<ResponseDto> response = fashionService.deleteFashion(fashionNumber, userId);
    //     return response;
    // }

    // @PatchMapping("/{fashionNumber}")
    // public ResponseEntity<ResponseDto> patchTravelCafe(
    //         @RequestBody @Valid PatchTravelCafeRequestDto requestBody,
    //         @PathVariable("fashionNumber") Integer fashionNumber,
    //         @AuthenticationPrincipal String userId) {
    //     ResponseEntity<ResponseDto> response = fashionService.patchFashion(null, fashionNumber, userId);
    //     return response;
    // }
}
