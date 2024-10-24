package com.koreait.mzpick_backend.controller.travel;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.travel.TravelSaveService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/travel/save")
@RequiredArgsConstructor
public class TravelSaveController {

    private final TravelSaveService travelSaveService;

    // controller 여행 게시판 저장 (저장 / 저장 취소) //
    @PutMapping("/{travelNumber}")
    public ResponseEntity<ResponseDto> putSave(
            @PathVariable("travelNumber") Integer travelNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = travelSaveService.putSave(travelNumber, userId);
        return response;
    }
}
