package com.koreait.mzpick_backend.service.travel_vote;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.travel.PostTravelVoteClickRequestDto;
import com.koreait.mzpick_backend.dto.request.travel.PostTravelVoteRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface TravelVoteService {
    ResponseEntity<ResponseDto> postTravelVote(PostTravelVoteRequestDto dto, String userId);
    ResponseEntity<ResponseDto> deleteTravelVote(Integer travelVoteNumber, String userId);
    ResponseEntity<ResponseDto> getVote();
    ResponseEntity<ResponseDto> clickVote(PostTravelVoteClickRequestDto dto, String userId);
    ResponseEntity<ResponseDto> totalVote(Integer travelVoteNumber);
}
