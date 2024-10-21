package com.koreait.mzpick_backend.controller.stay;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.request.stay.PatchTravelStayRequestDto;
import com.koreait.mzpick_backend.dto.request.stay.PostTravelStayRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.stay.TravelStayService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/stay")
@RequiredArgsConstructor
public class TravelStayController {
    private final TravelStayService travelStayService;

    @PostMapping(value = { "", "/" })
    public ResponseEntity<ResponseDto> postTravelStay(
            @RequestBody @Valid PostTravelStayRequestDto requestBody,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> resposne = travelStayService.postTravelStay(requestBody, userId);
        return resposne;
    }

    @DeleteMapping("/{travelStayNumber}")
    public ResponseEntity<ResponseDto> deleteTravelCafe(
            @PathVariable("travelStayNumber") Integer travelStayNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = travelStayService.deleteTravelStay(travelStayNumber, userId);
        return response;
    }

    @PatchMapping("/{travelStayNumber}")
    public ResponseEntity<ResponseDto> patchTravelCafe(
            @RequestBody @Valid PatchTravelStayRequestDto requestBody,
            @PathVariable("travelStayNumber") Integer travelStayNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = travelStayService.patchTravelStay(requestBody, travelStayNumber, userId);
        return response;
    }
}
