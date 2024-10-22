package com.koreait.mzpick_backend.controller.cafe;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.request.cafe.PatchTravelCafeRequestDto;
import com.koreait.mzpick_backend.dto.request.cafe.PostTravelCafeRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.cafe.TravelCafeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/cafe")
@RequiredArgsConstructor
public class TravelCafeController {
    private final TravelCafeService travelCafeService;

    // @GetMapping("/list")
    // public ResponseEntity<? super GetTevelCafeListResponseDto> getTravelList(@RequestParam("page") Integer page) {
    //     ResponseEntity<? super GetTevelCafeListResponseDto> resposne = travelCafeService.getTravelCafe();
    //     return resposne;
    // }

    @GetMapping("/{travelCafeNumber}")
    public ResponseEntity<ResponseDto> getTravelCafeNum(
            @PathVariable("travelCafeNumber")Integer travelCafeNumber
            ) {
        ResponseEntity<ResponseDto> resposne = travelCafeService.getTravelCafeNum(travelCafeNumber);
        return resposne;
    }
    @PostMapping(value = { "", "/" })
    public ResponseEntity<ResponseDto> postTravelCafe(
            @RequestBody @Valid PostTravelCafeRequestDto requestBody,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> resposne = travelCafeService.postTravelCafe(requestBody, userId);
        return resposne;
    }

    @DeleteMapping("/{travelCafeNumber}")
    public ResponseEntity<ResponseDto> deleteTravelCafe(
            @PathVariable("travelCafeNumber") Integer travelCafeNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = travelCafeService.deleteTravelCafe(travelCafeNumber, userId);
        return response;
    }

    @PatchMapping("/{travelCafeNumber}")
    public ResponseEntity<ResponseDto> patchTravelCafe (
            @RequestBody @Valid PatchTravelCafeRequestDto requestBody,
            @PathVariable("travelCafeNumber") Integer travelCafeNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = travelCafeService.patchTravelCafe(requestBody, travelCafeNumber, userId);
        return response;
    }
}
