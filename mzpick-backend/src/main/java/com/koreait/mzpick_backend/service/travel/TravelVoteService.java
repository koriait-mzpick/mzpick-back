package com.koreait.mzpick_backend.service.travel;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.travel.PostTravelVoteRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.travel.GetTravelVoteDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.travel.GetTravelVoteListResponseDto;
import com.koreait.mzpick_backend.dto.response.travel.GetTravelVoteTotalCountResponseDto;

//service 여행 관련 투표 서비스 //
public interface TravelVoteService {

    ResponseEntity<? super GetTravelVoteListResponseDto> getTravelVoteList();

    ResponseEntity<? super GetTravelVoteDetailResponseDto> getTravelVote(Integer travelVoteNumber);

    ResponseEntity<ResponseDto> postTravelVote(PostTravelVoteRequestDto dto, String userId);

    ResponseEntity<ResponseDto> deleteTravelVote(Integer travelVoteNumber, String userId);

    ResponseEntity<ResponseDto> clickVote(Integer selectNumber,Integer travelVoteNumber, String userId);

    ResponseEntity<? super GetTravelVoteTotalCountResponseDto> totalVote(Integer travelVoteNumber);
}
