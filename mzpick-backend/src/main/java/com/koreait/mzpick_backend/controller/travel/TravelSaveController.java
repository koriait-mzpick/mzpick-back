package com.koreait.mzpick_backend.controller.travel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.travel.TravelSaveService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/travel/save")
@RequiredArgsConstructor
public class TravelSaveController {
    
    private final TravelSaveService travelSaveService;

    @GetMapping("/{travelNumber}")
    public ResponseEntity<ResponseDto> postSave(
        @RequestBody @Valid Integer travelNumber
    ) {
        

        ResponseEntity<ResponseDto> response = travelSaveService.postSave();
        return response;
    }
}
