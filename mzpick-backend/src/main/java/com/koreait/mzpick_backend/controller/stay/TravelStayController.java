package com.koreait.mzpick_backend.controller.stay;

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

import com.koreait.mzpick_backend.dto.request.stay.PatchTravelStayRequestDto;
import com.koreait.mzpick_backend.dto.request.stay.PostTravelStayRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.stay.GetTravelStayDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.stay.GetTravelStayListResponseDto;
import com.koreait.mzpick_backend.service.stay.TravelStayService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/stay")
@RequiredArgsConstructor
public class TravelStayController {
    private final TravelStayService travelStayService;

    // controller 여행게시판 리스트 불러오기//
    @GetMapping(value = { "", "/" })
    public ResponseEntity<? super GetTravelStayListResponseDto> getTravelStayList(@RequestParam("page") Integer page) {
        ResponseEntity<? super GetTravelStayListResponseDto> resposne = travelStayService.getTravelStayList(page);
        return resposne;
    }

    // controller 해당 여행 게시판 불러오기//
    @GetMapping("/{travelNumber}")
    public ResponseEntity<? super GetTravelStayDetailResponseDto> getTravel(
            @PathVariable("travelStayNumber") Integer travelStayNumber) {
        ResponseEntity<? super GetTravelStayDetailResponseDto> resposne = travelStayService
                .getTravelStay(travelStayNumber);
        return resposne;
    }

    // controller 여행 게시판 작성하기 //
    @PostMapping(value = { "", "/" })
    public ResponseEntity<ResponseDto> postTravelStay(
            @RequestBody @Valid PostTravelStayRequestDto requestBody,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> resposne = travelStayService.postTravelStay(requestBody, userId);
        return resposne;
    }

    // controller 해당 여행 게시판 삭제하기 //
    @DeleteMapping("/{travelStayNumber}")
    public ResponseEntity<ResponseDto> deleteTravelStay(
            @PathVariable("travelStayNumber") Integer travelStayNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = travelStayService.deleteTravelStay(travelStayNumber, userId);
        return response;
    }

    // controller 해당 여행 게시판 수정하기 //
    @PatchMapping("/{travelStayNumber}")
    public ResponseEntity<ResponseDto> patchStayTravel(
            @RequestBody @Valid PatchTravelStayRequestDto requestBody,
            @PathVariable("travelStayNumber") Integer travelStayNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = travelStayService.patchTravelStay(requestBody, travelStayNumber, userId);
        return response;
    }

    // controller 해당 여행 게시판 조회수 증가 시키기 //
    @PostMapping("/view/{travelStayNumber}")
    public ResponseEntity<ResponseDto> upTravelViewCount(
            @PathVariable("travelStayNumber") Integer travelStayNumber) {
        ResponseEntity<ResponseDto> response = travelStayService.upTravelStayViewCount(travelStayNumber);
        return response;
    }
}
