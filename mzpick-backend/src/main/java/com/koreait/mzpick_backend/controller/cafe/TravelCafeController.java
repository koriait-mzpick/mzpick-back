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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.request.cafe.PatchTravelCafeRequestDto;
import com.koreait.mzpick_backend.dto.request.cafe.PostTravelCafeRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.cafe.GetTravelCafeDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.cafe.GetTravelCafeListResponseDto;
import com.koreait.mzpick_backend.service.cafe.TravelCafeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/cafe")
@RequiredArgsConstructor
public class TravelCafeController {
    private final TravelCafeService travelCafeService;

    // controller 여행게시판 리스트 불러오기//
    @GetMapping(value = { "", "/" })
    public ResponseEntity<? super GetTravelCafeListResponseDto> getTravelCafeList(@RequestParam("page") Integer page) {
        ResponseEntity<? super GetTravelCafeListResponseDto> resposne = travelCafeService.getTravelCafeList(page);
        return resposne;
    }

    // controller 해당 여행 게시판 불러오기//
    @GetMapping("/{travelNumber}")
    public ResponseEntity<? super GetTravelCafeDetailResponseDto> getTravel(
            @PathVariable("travelCafeNumber") Integer travelCafeNumber) {
        ResponseEntity<? super GetTravelCafeDetailResponseDto> resposne = travelCafeService
                .getTravelCafe(travelCafeNumber);
        return resposne;
    }

    // controller 여행 게시판 작성하기 //
    @PostMapping(value = { "", "/" })
    public ResponseEntity<ResponseDto> postTravelCafe(
            @RequestBody @Valid PostTravelCafeRequestDto requestBody,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> resposne = travelCafeService.postTravelCafe(requestBody, userId);
        return resposne;
    }

    // controller 해당 여행 게시판 삭제하기 //
    @DeleteMapping("/{travelCafeNumber}")
    public ResponseEntity<ResponseDto> deleteTravelCafe(
            @PathVariable("travelCafeNumber") Integer travelCafeNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = travelCafeService.deleteTravelCafe(travelCafeNumber, userId);
        return response;
    }

    // controller 해당 여행 게시판 수정하기 //
    @PatchMapping("/{travelCafeNumber}")
    public ResponseEntity<ResponseDto> patchCafeTravel(
            @RequestBody @Valid PatchTravelCafeRequestDto requestBody,
            @PathVariable("travelCafeNumber") Integer travelCafeNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = travelCafeService.patchTravelCafe(requestBody, travelCafeNumber, userId);
        return response;
    }

    // controller 해당 여행 게시판 조회수 증가 시키기 //
    @PostMapping("/view/{travelCafeNumber}")
    public ResponseEntity<ResponseDto> upTravelViewCount(
            @PathVariable("travelCafeNumber") Integer travelCafeNumber) {
        ResponseEntity<ResponseDto> response = travelCafeService.upTravelCafeViewCount(travelCafeNumber);
        return response;
    }
}
