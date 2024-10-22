package com.koreait.mzpick_backend.controller.travel;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.request.travel.PostTravelVoteClickRequestDto;
import com.koreait.mzpick_backend.dto.request.travel.PostTravelVoteRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.travel.GetTravelVoteDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.travel.GetTravelVoteListResponseDto;
import com.koreait.mzpick_backend.service.travel.TravelVoteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/travel/vote")
@RequiredArgsConstructor
public class TravelVoteController {
    private final TravelVoteService travelVoteService;

    // controller 여행 관련 투표 리스트 불러오기 //
    @GetMapping(value = { "", "/" })
    public ResponseEntity<? super GetTravelVoteListResponseDto> getTravelVoteList() {
        ResponseEntity<? super GetTravelVoteListResponseDto> response = travelVoteService.getTravelVoteList();
        return response;
    }

    // controller 해당 여행 관련 투표 게시글 불러오기 //
    @GetMapping("/{travelVoteNumber}")
    public ResponseEntity<? super GetTravelVoteDetailResponseDto> getTravelVote(
        @PathVariable("travelVoteNumber") Integer travelVoteNumber
    ) {
        ResponseEntity<? super GetTravelVoteDetailResponseDto> response = travelVoteService.getTravelVote(travelVoteNumber);
        return response;
    }

    // controller 여행 관련 투표 게시글 작성하기
    @PostMapping(value = { "", "/" })
    public ResponseEntity<ResponseDto> postTravelVote(
            @RequestBody @Valid PostTravelVoteRequestDto dto,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = travelVoteService.postTravelVote(dto, userId);
        return response;
    }

    // controller 해당 여행 게시판 투표 클릭 (투표하기 / 투표취소) //
    @PutMapping("/vote-click/{travelVoteNumber}")
    public ResponseEntity<ResponseDto> putVoteClick(
            @PathVariable("travelVoteNumber") Integer travelVoteNumber,
            @RequestBody @Valid PostTravelVoteClickRequestDto dto,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = travelVoteService.clickVote(dto, travelVoteNumber, userId);
        return response;
    }

    //controller 해당 여행 투표 관련 게시판 삭제하기 //
    @DeleteMapping("/{travelVoteNumber}")
    public ResponseEntity<ResponseDto> deleteTravel(
            @PathVariable("travelVoteNumber") Integer travelVoteNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = travelVoteService.deleteTravelVote(travelVoteNumber, userId);
        return response;
    }

    // @GetMapping("/vote-total/{travelVoteNumber}")
    // public ResponseEntity<ResponseDto> totalVote(
    //         @PathVariable("travelVoteNumber") Integer travelVoteNumber) {
    //     ResponseEntity<ResponseDto> response = travelVoteService.totalVote(travelVoteNumber);
    //     return response;
    // }

}
