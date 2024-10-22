package com.koreait.mzpick_backend.controller.stay;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.stay.TravelStayLikeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/stay/like")
@RequiredArgsConstructor
public class TravelStayLikeController {
    
    private final TravelStayLikeService travelStayLikeService;

    @GetMapping("/{travelStayNumber}")
    public ResponseEntity<ResponseDto> getLike(
        @PathVariable("travelStayNumber")Integer travelStayNumber
    ) {
        ResponseEntity<ResponseDto> response = travelStayLikeService.getLIke(travelStayNumber);
        return response;
    }

    @PostMapping("/{travelStayNumber}")
    public ResponseEntity<ResponseDto> postLike(
        @PathVariable("travelStayNumber")Integer travelStayNumber,
        @RequestBody @Valid String requestBody,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = travelStayLikeService.getLIke(travelStayNumber);
        return response;
    }
}
