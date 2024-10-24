package com.koreait.mzpick_backend.controller.fashion;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.fashion.FashionSaveService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/fashion/save")
@RequiredArgsConstructor
public class FashionSaveController {
    
    private final FashionSaveService fashionSaveService;

    @PutMapping("/{fashionNumber}")
    public ResponseEntity<ResponseDto> postSave(
        @PathVariable("fashionNumber")Integer fashionNumber,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = fashionSaveService.postSave(fashionNumber, userId);
        return response;
    }

}
