package com.koreait.mzpick_backend.controller.food;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.food.TravelFoodSaveService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/food/save")
@RequiredArgsConstructor
public class TravelFoodSaveController {

    private final TravelFoodSaveService travelFoodSaveService;
    
    @PostMapping("/{travelFoodNumber}")
    public ResponseEntity<ResponseDto> postSave(
        @PathVariable("travelFoodNumber")Integer travelFoodNumber,
        @RequestBody @Valid String requestBody,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = travelFoodSaveService.postSave(travelFoodNumber, userId);
        return response;
    }
}
