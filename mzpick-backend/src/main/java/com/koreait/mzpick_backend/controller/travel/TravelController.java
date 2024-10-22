package com.koreait.mzpick_backend.controller.travel;

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

import com.koreait.mzpick_backend.dto.request.travel.PatchTravelRequestDto;
import com.koreait.mzpick_backend.dto.request.travel.PostTravelRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.travel.GetTravelDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.travel.GetTravelListResponseDto;
import com.koreait.mzpick_backend.service.travel.TravelService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/travel")
@RequiredArgsConstructor
public class TravelController {
    private final TravelService travelService;

    @GetMapping("/list")
    public ResponseEntity<? super GetTravelListResponseDto> getTravelList(@RequestParam("page") Integer page){
        ResponseEntity<? super GetTravelListResponseDto> resposne = travelService.getTravelList(page);
        return resposne;
    }
    @GetMapping("/{travelNumber}")
    public ResponseEntity<? super GetTravelDetailResponseDto> getTravel(
        @PathVariable("travelNumber") Integer travelNumber
    ){
        ResponseEntity<? super GetTravelDetailResponseDto> resposne = travelService.getTravel(travelNumber);
        return resposne;
    }

    @PostMapping(value = {"", "/"})
    public ResponseEntity<ResponseDto> postTravel(
        @RequestBody @Valid PostTravelRequestDto requestBody,
        @AuthenticationPrincipal String userId
    ){
        ResponseEntity<ResponseDto> resposne = travelService.postTravel(requestBody, userId);
        return resposne;
    }

    @DeleteMapping("/{travelNumber}")
    public ResponseEntity<ResponseDto> deleteTravel(
        @PathVariable("travelNumber") Integer travelNumber,
        @AuthenticationPrincipal String userId
    ){
        ResponseEntity<ResponseDto> response = travelService.deleteTravel(travelNumber, userId);
        return response;
    }

    @PatchMapping("/{travelNumber}")
    public ResponseEntity<ResponseDto> patchTravel(
        @RequestBody @Valid PatchTravelRequestDto requestBody,
        @PathVariable("travelNumber") Integer travelNumber,
        @AuthenticationPrincipal String userId
    ){
        ResponseEntity<ResponseDto> response = travelService.patchTravel(requestBody, travelNumber, userId);
        return response;
    }

    @PostMapping("/view/{travelNumber}")
    public ResponseEntity<ResponseDto> upTravelViewCount(
        @PathVariable("travelNumber") Integer travelNumber
    ){
        ResponseEntity<ResponseDto> response = travelService.upTravelViewCount(travelNumber);
        return response;
    }
    
}
