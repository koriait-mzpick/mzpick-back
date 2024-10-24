package com.koreait.mzpick_backend.service.implement.mypage;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.mypage.MyPageSaveService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyPageSaveServiceImplement implements MyPageSaveService {@Override
    public ResponseEntity<ResponseDto> userSaveTravel() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'userSaveTravel'");
    }

    @Override
    public ResponseEntity<ResponseDto> userSaveFood() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'userSaveFood'");
    }

    @Override
    public ResponseEntity<ResponseDto> userSaveStay() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'userSaveStay'");
    }

    @Override
    public ResponseEntity<ResponseDto> userSaveFashion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'userSaveFashion'");
    }
    
}
