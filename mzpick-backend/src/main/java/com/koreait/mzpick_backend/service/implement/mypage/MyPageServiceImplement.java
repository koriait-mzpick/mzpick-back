package com.koreait.mzpick_backend.service.implement.mypage;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.mypage.MyPageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyPageServiceImplement implements MyPageService{@Override
    public ResponseEntity<ResponseDto> userDelete(String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'userDelete'");
    }

    @Override
    public ResponseEntity<ResponseDto> userBoardRead() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'userBoardRead'");
    }

    @Override
    public ResponseEntity<ResponseDto> userLikeBoardRead() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'userLikeBoardRead'");
    }

    @Override
    public ResponseEntity<ResponseDto> userSaveBoardRead() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'userSaveBoardRead'");
    }

    @Override
    public ResponseEntity<ResponseDto> userPostVoteRead() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'userPostVoteRead'");
    }
    
}
