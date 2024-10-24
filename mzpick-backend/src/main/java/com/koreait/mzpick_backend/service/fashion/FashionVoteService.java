package com.koreait.mzpick_backend.service.fashion;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.fashion.PostFashionlVoteRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.fashion.GetFashionCommentListResponseDto;
import com.koreait.mzpick_backend.dto.response.fashion.GetFashionVoteDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.fashion.GetFashionVoteListResponseDto;
import com.koreait.mzpick_backend.dto.response.fashion.GetFashionVoteTotalCountResponseDto;

public interface FashionVoteService {
    ResponseEntity<? super GetFashionVoteListResponseDto> getFashionVoteList();
    ResponseEntity<? super GetFashionVoteDetailResponseDto> getTravelVote(Integer fashionVoteNumber);
    ResponseEntity<ResponseDto> postFashionVote(PostFashionlVoteRequestDto dto, String userId);
    ResponseEntity<ResponseDto> deleteFashionVote(Integer fashionVoteNumber, String userId);
    ResponseEntity<ResponseDto> clickVote(Integer selectNumber, Integer fashionVoteNumber, String userId);
    ResponseEntity<? super GetFashionVoteTotalCountResponseDto> totalVote(Integer fashionVoteNumber);
}
