package com.koreait.mzpick_backend.controller.fashion;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.service.fashion.FashionVoteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/fashion/vote")
@RequiredArgsConstructor
public class FashionVoteController {

    private final FashionVoteService fashionVoteService;

    // @GetMapping(value = { "", "/" })
    // public ResponseEntity<ResponseDto> getVote() {
    //     ResponseEntity<ResponseDto> response = fashionVoteService.getVote();
    //     return response;
    // }

    // @PostMapping(value = { "", "/" })
    // public ResponseEntity<ResponseDto> postVote(
    //         @RequestBody @Valid String dto,
    //         @AuthenticationPrincipal String userId) {
    //     ResponseEntity<ResponseDto> response = fashionVoteService.postVote(dto, userId);
    //     return response;
    // }

    // @PostMapping("/vote-click")
    // public ResponseEntity<ResponseDto> clickVote(
    //         @RequestBody @Valid PostFashionVoteClickRequestDto dto,
    //         @AuthenticationPrincipal String userId) {
    //     ResponseEntity<ResponseDto> response = fashionVoteService.clickVote(dto, userId);
    //     return response;
    // }

    // @PostMapping("/boardwrite")
    // public ResponseEntity<ResponseDto> boardVote(
    //         @RequestBody @Valid String dto,
    //         @AuthenticationPrincipal String userId) {
    //     ResponseEntity<ResponseDto> response = fashionVoteService.boardVote(dto, userId);
    //     return response;
    // }

    // @GetMapping("/vote-total/{fashionVoteNumber}")
    // public ResponseEntity<ResponseDto> totalVote(
    //         @PathVariable("fashionVoteNumber") Integer fashionVoteNumber) {
    //     ResponseEntity<ResponseDto> response = fashionVoteService.totalVote(fashionVoteNumber);
    //     return response;
    // }
}
