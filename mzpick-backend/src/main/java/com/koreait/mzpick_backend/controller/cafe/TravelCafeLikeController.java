package com.koreait.mzpick_backend.controller.cafe;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.cafe.TravelCafeLikeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/cafe/like")
@RequiredArgsConstructor
public class TravelCafeLikeController {
    
    private final TravelCafeLikeService travelCafeLikeService;

    // controller 해당 여행 게시판 좋아요 버튼 (클릭 / 클릭 해제) //
    @PutMapping("/{travelCafeNumber}")
    public ResponseEntity<ResponseDto> putLike(
        @PathVariable("travelCafeNumber") Integer travelCafeNumber,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = travelCafeLikeService.putLike(travelCafeNumber, userId);
        return response;
    }
}
