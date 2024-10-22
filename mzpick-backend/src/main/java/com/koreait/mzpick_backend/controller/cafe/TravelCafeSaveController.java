package com.koreait.mzpick_backend.controller.cafe;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.service.cafe.TravelCafeSaveService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/cafe/save")
@RequiredArgsConstructor
public class TravelCafeSaveController {
    
    private final TravelCafeSaveService travelCafeSaveService;

    // @PutMapping("/{travelCafeNumber}")
    // public ResponseEntity<ResponseDto> putSave(
    //         @PathVariable("travelCafeNumber") Integer travelCafeNumber,
    //         @AuthenticationPrincipal String userId) {
    //     ResponseEntity<ResponseDto> response = travelCafeSaveService.putSave(travelCafeNumber, userId);
    //     return response;
    // }

}
