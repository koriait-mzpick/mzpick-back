package com.koreait.mzpick_backend.service.implement.travel_vote;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.request.travel.PostTravelVoteClickRequestDto;
import com.koreait.mzpick_backend.dto.request.travel.PostTravelVoteRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.travel_vote.TravelVoteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelVoteServiceImplement implements TravelVoteService{@Override
    public ResponseEntity<ResponseDto> getVote() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getVote'");
    }

    @Override
    public ResponseEntity<ResponseDto> postVote(PostTravelVoteRequestDto dto, String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postVote'");
    }

    @Override
    public ResponseEntity<ResponseDto> clickVote(PostTravelVoteClickRequestDto dto, String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clickVote'");
    }

    @Override
    public ResponseEntity<ResponseDto> totalVote(Integer travelVoteNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'totalVote'");
    }

    @Override
    public ResponseEntity<ResponseDto> boardVote(String dto, String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'boardVote'");
    }
    
}
