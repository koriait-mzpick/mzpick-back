package com.koreait.mzpick_backend.service.fashion_vote;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.fashion.PostFashionVoteClickRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface FashionVoteService {
    ResponseEntity<ResponseDto> getVote();
    ResponseEntity<ResponseDto> postVote(String dto, String userId);
    ResponseEntity<ResponseDto> boardVote(String dto, String userId);
    ResponseEntity<ResponseDto> clickVote(PostFashionVoteClickRequestDto dto, String userId);
    ResponseEntity<ResponseDto> totalVote(Integer travelVoteNumber);
}
