package com.koreait.mzpick_backend.controller.stay;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.stay.TravelStaySaveService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/stay/save")
@RequiredArgsConstructor
public class TravelStaySaveController {
    
    private final TravelStaySaveService travelStaySaveService;

    // controller 여행 게시판 저장 (저장 / 저장 취소) //
    @PutMapping("/{travelStayNumber}")
    public ResponseEntity<ResponseDto> putSave(
            @PathVariable("travelStayNumber") Integer travelStayNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = travelStaySaveService.putSave(travelStayNumber, userId);
        return response;
    }
}
