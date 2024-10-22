package com.koreait.mzpick_backend.controller.fashion;

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
import com.koreait.mzpick_backend.service.fashion.FashionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/fashion")
@RequiredArgsConstructor
public class FashionController {
    private final FashionService fashionService;

    @GetMapping(value = { "", "/" })
    public ResponseEntity<ResponseDto> getFashion(
            ) {
        ResponseEntity<ResponseDto> resposne = fashionService.getFashion();
        return resposne;
    }
    @GetMapping("/{fashionNumber}")
    public ResponseEntity<ResponseDto> getFashionNum(
            @PathVariable("fashionNumber")Integer fashionNumber
            ) {
        ResponseEntity<ResponseDto> resposne = fashionService.getFashionNum(fashionNumber);
        return resposne;
    }
    @PostMapping(value = { "", "/" })
    public ResponseEntity<ResponseDto> postFashion(
            @RequestBody @Valid PostTravelCafeRequestDto requestBody,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> resposne = fashionService.postFashion(null, userId);
        return resposne;
    }

    @DeleteMapping("/{fashionNumber}")
    public ResponseEntity<ResponseDto> deleteFashion(
            @PathVariable("fashionNumber") Integer fashionNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = fashionService.deleteFashion(fashionNumber, userId);
        return response;
    }

    @PatchMapping("/{fashionNumber}")
    public ResponseEntity<ResponseDto> patchTravelCafe (
            @RequestBody @Valid PatchTravelCafeRequestDto requestBody,
            @PathVariable("fashionNumber") Integer fashionNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = fashionService.patchFashion(null, fashionNumber, userId);
        return response;
    }
}
