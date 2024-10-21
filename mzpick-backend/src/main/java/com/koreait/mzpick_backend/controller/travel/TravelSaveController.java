package com.koreait.mzpick_backend.controller.travel;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/travel/save")
@RequiredArgsConstructor
public class TravelSaveController {
    
    // private final TravelSaveService travelSaveService;

    // @GetMapping("/{travelNumber}")
    // public ResponseEntity<ResponseDto> postSave(
    //     @RequestBody @Valid Integer travelNumber
    // ) {
        

    //     ResponseEntity<ResponseDto> response = travelSaveService.postSave();
    //     return response;
    // }
}
