package com.koreait.mzpick_backend.controller.cafe;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.cafe.TravelCafeSaveService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/cafe/save")
@RequiredArgsConstructor
public class TravelCafeSaveController {
    
    private final TravelCafeSaveService travelCafeSaveService;

    // controller 여행 게시판 저장 (저장 / 저장 취소) //
    @PutMapping("/{travelCafeNumber}")
    public ResponseEntity<ResponseDto> putSave(
            @PathVariable("travelCafeNumber") Integer travelCafeNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = travelCafeSaveService.putSave(travelCafeNumber, userId);
        return response;
    }
}
