package com.koreait.mzpick_backend.controller.travel_vote;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.request.travel.PostTravelVoteClickRequestDto;
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

    @GetMapping(value={"", "/"})
    public ResponseEntity<ResponseDto> getVote() {
        ResponseEntity<ResponseDto> response = travelVoteService.getVote();
        return response;
    }
    @PostMapping(value={"", "/"})
    public ResponseEntity<ResponseDto> postVote(
        @RequestBody @Valid PostTravelVoteRequestDto dto,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = travelVoteService.postVote(dto, userId);
        return response;
    }
    @PostMapping("/vote-click")
    public ResponseEntity<ResponseDto> clickVote(
        @RequestBody @Valid PostTravelVoteClickRequestDto dto,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = travelVoteService.clickVote(dto, userId);
        return response;
    }

    @PostMapping("/boardwrite")
    public ResponseEntity<ResponseDto> boardVote(
        @RequestBody @Valid String dto,
        @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<ResponseDto> response = travelVoteService.boardVote(dto, userId);
        return response;
    }

    @GetMapping("/vote-total/{travelVoteNumber}")
    public ResponseEntity<ResponseDto> totalVote(
        @PathVariable("travelVoteNumber")Integer travelVoteNumber
    ) {
        ResponseEntity<ResponseDto> response = travelVoteService.totalVote(travelVoteNumber);
        return response;
    }

}
