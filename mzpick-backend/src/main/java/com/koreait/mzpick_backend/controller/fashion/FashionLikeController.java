package com.koreait.mzpick_backend.controller.fashion;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.fashion.FashionLikeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/fashion/like")
@RequiredArgsConstructor
public class FashionLikeController {

    private final FashionLikeService fashionLikeService;

    @PutMapping("/{fashionNumber}")
    public ResponseEntity<ResponseDto> putLike(
            @PathVariable("fashionNumber") Integer fashionNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = fashionLikeService.putLike(fashionNumber, userId);
        return response;
    }

}
