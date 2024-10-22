package com.koreait.mzpick_backend.service.implement.fashion;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.request.fashion.PostFashionVoteClickRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.fashion.FashionVoteService;

@Service
public record FashionVoteServiceImplement() implements FashionVoteService {

    @Override
    public ResponseEntity<ResponseDto> getVote() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getVote'");
    }

    @Override
    public ResponseEntity<ResponseDto> postVote(String dto, String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postVote'");
    }

    @Override
    public ResponseEntity<ResponseDto> boardVote(String dto, String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'boardVote'");
    }

    @Override
    public ResponseEntity<ResponseDto> clickVote(PostFashionVoteClickRequestDto dto, String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clickVote'");
    }

    @Override
    public ResponseEntity<ResponseDto> totalVote(Integer travelVoteNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'totalVote'");
    }
    
}
