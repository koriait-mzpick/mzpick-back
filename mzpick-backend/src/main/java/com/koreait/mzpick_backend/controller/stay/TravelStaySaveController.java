package com.koreait.mzpick_backend.controller.stay;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.service.stay.TravelStaySaveService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/stay/save")
@RequiredArgsConstructor
public class TravelStaySaveController {
    
    private final TravelStaySaveService travelStaySaveService;

    // @PostMapping("/{travelStayNumber}")
    // public ResponseEntity<ResponseDto> postSave(
    //     @PathVariable("travelNumber") Integer travelStayNumber,
    //     @RequestBody @Valid String requestBody,
    //     @AuthenticationPrincipal String userId
    // ) {
    //     ResponseEntity<ResponseDto> response = travelStaySaveService.postSave(null, null);
    //     return response;
    // }
}
