package com.koreait.mzpick_backend.controller.food;

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

import com.koreait.mzpick_backend.dto.request.food.PatchTravelFoodRequestDto;
import com.koreait.mzpick_backend.dto.request.food.PostTravelFoodRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;

import com.koreait.mzpick_backend.service.food.TravelFoodService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/food")
@RequiredArgsConstructor
public class TravelFoodController {

    private final TravelFoodService travelFoodService;

    @GetMapping(value = { "", "/" })
    public ResponseEntity<ResponseDto> getTravelFood(
            ) {
        ResponseEntity<ResponseDto> resposne = travelFoodService.getTravelFood();
        return resposne;
    }
    @GetMapping("/{travelFoodNumber}")
    public ResponseEntity<ResponseDto> getTravelFoodNum(
            @PathVariable("travelFoodNumber")Integer travelFoodNumber
            ) {
        ResponseEntity<ResponseDto> resposne = travelFoodService.getTravelFoodNum(travelFoodNumber);
        return resposne;
    }
    @PostMapping(value = { "", "/" })
    public ResponseEntity<ResponseDto> postTravelFood(
            @RequestBody @Valid PostTravelFoodRequestDto requestBody,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> resposne = travelFoodService.postTravelFood(requestBody, userId);
        return resposne;
    }

    @DeleteMapping("/{travelFoodNumber}")
    public ResponseEntity<ResponseDto> deleteTravelFood(
            @PathVariable("travelFoodNumber") Integer travelFoodNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = travelFoodService.deleteTravelFood(travelFoodNumber, userId);
        return response;
    }

    @PatchMapping("/{travelFoodNumber}")
    public ResponseEntity<ResponseDto> patchTravelFood (
            @RequestBody @Valid PatchTravelFoodRequestDto requestBody,
            @PathVariable("travelFoodNumber") Integer travelFoodNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = travelFoodService.patchTravelFood(requestBody, travelFoodNumber, userId);
        return response;
    }
}
