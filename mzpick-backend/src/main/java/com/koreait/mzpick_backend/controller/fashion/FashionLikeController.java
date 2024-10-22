package com.koreait.mzpick_backend.controller.fashion;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.cafe.TravelCafeLikeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/cafe/like")
@RequiredArgsConstructor
public class FashionLikeController {
    
    private final TravelCafeLikeService travelCafeLikeService;

    @GetMapping("/{travelCafeNumber}")
    public ResponseEntity<ResponseDto> getLike(
        @PathVariable("travelCafeNumber")Integer travelCafeNumber
    ) {
        ResponseEntity<ResponseDto> response = travelCafeLikeService.getLike(travelCafeNumber);
        return response;
    }

    @PostMapping("/{travelCafeNumber}")
    public ResponseEntity<ResponseDto> postLike(
        @RequestBody @Valid String requestBody,
        @PathVariable("travelCafeNumber")Integer travelCafeNumber,
        @AuthenticationPrincipal String userid
    ) {
        ResponseEntity<ResponseDto> response = travelCafeLikeService.getLike(travelCafeNumber);
        return response;
    }
}
