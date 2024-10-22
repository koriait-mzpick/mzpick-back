package com.koreait.mzpick_backend.service.travel_vote;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.travel.PostTravelVoteRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface TravelVoteService {
    REsponse
    ResponseEntity<ResponseDto> postTravelVote(PostTravelVoteRequestDto dto, String userId);
    ResponseEntity<ResponseDto> deleteTravelVote(Integer travelVoteNumber, String userId);

}
