package com.koreait.mzpick_backend.controller.stay;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.stay.TravelStayLikeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/stay/like")
@RequiredArgsConstructor
public class TravelStayLikeController {
    
    private final TravelStayLikeService travelStayLikeService;

    // controller 해당 여행 게시판 좋아요 버튼 (클릭 / 클릭 해제) //
    @PutMapping("/{travelStayNumber}")
    public ResponseEntity<ResponseDto> putLike(
        @PathVariable("travelStayNumber") Integer travelStayNumber,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = travelStayLikeService.putLike(travelStayNumber, userId);
        return response;
    }
}
