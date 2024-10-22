package com.koreait.mzpick_backend.service.keyword;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface KeywordService {
    
    ResponseEntity<ResponseDto> getKeyword();
    ResponseEntity<ResponseDto> postKeyword(String dto, String userId);
}
