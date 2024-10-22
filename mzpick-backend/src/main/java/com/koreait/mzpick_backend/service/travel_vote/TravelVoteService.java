package com.koreait.mzpick_backend.service.travel_vote;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.travel.PostTravelVoteClickRequestDto;
import com.koreait.mzpick_backend.dto.request.travel.PostTravelVoteRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface  TravelVoteService {
    
    ResponseEntity<ResponseDto> getVote();
    ResponseEntity<ResponseDto> postVote(PostTravelVoteRequestDto dto, String userId);
    ResponseEntity<ResponseDto> boardVote(String dto, String userId);
    ResponseEntity<ResponseDto> clickVote(PostTravelVoteClickRequestDto dto, String userId);
    ResponseEntity<ResponseDto> totalVote(Integer travelVoteNumber);
}
