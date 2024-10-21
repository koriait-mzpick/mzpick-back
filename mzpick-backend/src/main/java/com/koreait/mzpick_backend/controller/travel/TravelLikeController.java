package com.koreait.mzpick_backend.controller.travel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.travel.TravelLikeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/travel/like")
@RequiredArgsConstructor
public class TravelLikeController {

    private final TravelLikeService travelLikeService;

    @GetMapping("/{travelNumber}")
    public ResponseEntity<ResponseDto> getLike() {
        

        ResponseEntity<ResponseDto> response = travelLikeService.getLike();
        return response;
    }
    @GetMapping("/{travelNumber}")
    public ResponseEntity<ResponseDto> postLike(
        @RequestBody @Valid Integer travelNumber
    ) {
        

        ResponseEntity<ResponseDto> response = travelLikeService.postLike();
        return response;
    }

}
