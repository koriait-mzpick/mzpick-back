package com.koreait.mzpick_backend.controller.travel_vote;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.request.travel.PostTravelVoteRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.travel_vote.TravelVoteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/travel/vote")
@RequiredArgsConstructor
public class TravelVoteController {

    private final TravelVoteService travelVoteService;

    @PostMapping(value = { "", "/" })
    public ResponseEntity<ResponseDto> postTravel(
            @RequestBody @Valid PostTravelVoteRequestDto requestBody,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> resposne = travelVoteService.postTravelVote(requestBody, userId);
        return resposne;
    }

    @DeleteMapping("/{travelVoteNumber}")
    public ResponseEntity<ResponseDto> deleteTravel(
            @PathVariable("travelVoteNumber") Integer travelVoteNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = travelVoteService.deleteTravelVote(travelVoteNumber, userId);
        return response;
    }
}
