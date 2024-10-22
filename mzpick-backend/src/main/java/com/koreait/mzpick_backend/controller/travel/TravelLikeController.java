package com.koreait.mzpick_backend.controller.travel;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
=======
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
>>>>>>> 242a098102e96732941b60a9bb4018fddb37203b
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.travel.TravelLikeService;

<<<<<<< HEAD
import jakarta.validation.Valid;
=======
>>>>>>> 242a098102e96732941b60a9bb4018fddb37203b
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/travel/like")
@RequiredArgsConstructor
public class TravelLikeController {

    private final TravelLikeService travelLikeService;

<<<<<<< HEAD
    @GetMapping("/{travelNumber}")
    public ResponseEntity<ResponseDto> getLike(
        @PathVariable("travelNumber")Integer travelNumber
    ) {
        ResponseEntity<ResponseDto> response = travelLikeService.getLike(travelNumber);
        return response;
    }
    @PostMapping("/{travelNumber}")
    public ResponseEntity<ResponseDto> postLike(
        @RequestBody @Valid String requestBody,
        @PathVariable("travelNumber")Integer travelNumber,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = travelLikeService.postLike(userId);
=======
    // @GetMapping("/{travelNumber}")
    // public ResponseEntity<ResponseDto> getLike() {
        

    //     ResponseEntity<ResponseDto> response = travelLikeService.getLike();
    //     return response;
    // }
    @PutMapping("/{travelNumber}")
    public ResponseEntity<ResponseDto> putLike(
        @PathVariable("travelNumber") Integer travelNumber,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = travelLikeService.putLike(travelNumber, userId);
>>>>>>> 242a098102e96732941b60a9bb4018fddb37203b
        return response;
    }
}
