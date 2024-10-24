package com.koreait.mzpick_backend.controller.fashion;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.request.fashion.PostFashionlVoteRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.fashion.GetFashionVoteDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.fashion.GetFashionVoteListResponseDto;
import com.koreait.mzpick_backend.dto.response.fashion.GetFashionVoteTotalCountResponseDto;
import com.koreait.mzpick_backend.service.fashion.FashionVoteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/fashion/vote")
@RequiredArgsConstructor
public class fashionVoteController {

    private final FashionVoteService fashionVoteService;

    @GetMapping(value = { "", "/" })
    public ResponseEntity<? super GetFashionVoteListResponseDto> getFashionVoteList() {
        ResponseEntity<? super GetFashionVoteListResponseDto> response = fashionVoteService.getFashionVoteList();
        return response;
    }

        @GetMapping("/{FashionVoteNumber}")
    public ResponseEntity<? super GetFashionVoteDetailResponseDto> getTravelVote(
            @PathVariable("FashionVoteNumber") Integer fashionVoteNumber) {
        ResponseEntity<? super GetFashionVoteDetailResponseDto> response = fashionVoteService.getTravelVote(fashionVoteNumber);
        return response;
    }

    @PostMapping(value = { "", "/" })
    public ResponseEntity<ResponseDto> postFashionVote(
            @RequestBody @Valid PostFashionlVoteRequestDto dto,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = fashionVoteService.postFashionVote(dto, userId);
        return response;
    }

    @PutMapping("/vote-click/{fashoinVoteNumber}/{selectNumber}")
    public ResponseEntity<ResponseDto> putclickVote(
            @PathVariable("fashoinVoteNumber") Integer fashoinVoteNumber,
            @PathVariable("selectNumber") Integer selectNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = fashionVoteService.clickVote(fashoinVoteNumber,selectNumber, userId);
        return response;
    }

    @GetMapping("/vote-total")
    public ResponseEntity<? super GetFashionVoteTotalCountResponseDto> totalFashionVote(
        @RequestParam("fashionVoteNumber") Integer fashionVoteNumber
        ){
        ResponseEntity<? super GetFashionVoteTotalCountResponseDto> response = fashionVoteService.totalVote(fashionVoteNumber);
        return response;
        }
}
