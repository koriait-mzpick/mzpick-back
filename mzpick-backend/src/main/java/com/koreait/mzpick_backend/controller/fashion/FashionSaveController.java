package com.koreait.mzpick_backend.controller.fashion;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.cafe.TravelCafeSaveService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/cafe/save")
@RequiredArgsConstructor
public class FashionSaveController {
    
    private final TravelCafeSaveService travelCafeSaveService;

    @PostMapping("/{travelCafeNumber}")
    public ResponseEntity<ResponseDto> postSave(
        @RequestBody @Valid String requestBody,
        @PathVariable("travelCafeNumber")Integer travelCafeNumber,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = travelCafeSaveService.postSave(travelCafeNumber, userId);
        return response;
    }

}
