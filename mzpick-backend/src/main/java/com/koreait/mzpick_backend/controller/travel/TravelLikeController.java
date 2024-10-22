package com.koreait.mzpick_backend.controller.travel;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.travel.TravelLikeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/travel/like")
@RequiredArgsConstructor
public class TravelLikeController {

    private final TravelLikeService travelLikeService;

    // controller 해당 여행 게시판 좋아요 버튼 (클릭 / 클릭 해제) //
    @PutMapping("/{travelNumber}")
    public ResponseEntity<ResponseDto> putLike(
        @PathVariable("travelNumber") Integer travelNumber,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = travelLikeService.putLike(travelNumber, userId);
        return response;
    }
}
