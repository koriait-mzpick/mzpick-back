package com.koreait.mzpick_backend.controller.food;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.food.TravelFoodService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/food")
@RequiredArgsConstructor
public class TravelFoodController {
    
    private final TravelFoodService travelFoodService;
    
    @GetMapping(value = {"", "/"})
    public ResponseEntity<ResponseDto> getFoodList() {

        ResponseEntity<ResponseDto> response = travelFoodService.getFoodList();
    }

    @GetMapping("/{travelNumber}")
    public ResponseEntity<ResponseDto> getFoodListNum(
        @PathVariable("travelNumber") Integer travelNumber
    ) {

        ResponseEntity<ResponseDto> response = travelFoodService.getFoodListNum();
    }
}
