package com.koreait.mzpick_backend.service.implement.keyword;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.keyword.KeywordService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KeyWordServiceImplement implements KeywordService{@Override
    public ResponseEntity<ResponseDto> getKeyword() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getKeyword'");
    }

    @Override
    public ResponseEntity<ResponseDto> postKeyword(String dto, String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postKeyword'");
    }
    
}
