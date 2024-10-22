package com.koreait.mzpick_backend.controller.popular_food;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.popular_food.PopularFoodService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/popular/food")
@RequiredArgsConstructor
public class PopulardFoodController {
    
    private final PopularFoodService popularFoodService;

    @GetMapping(value={"", "/"})
    public ResponseEntity<ResponseDto> getPopularFood() {
        ResponseEntity<ResponseDto> response = popularFoodService.getPopularFood();
        return response;
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseDto> postPopularFood(
        @RequestBody @Valid String dto,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = popularFoodService.postPopularFood(dto, userId);
        return response;
    }
}
