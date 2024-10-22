package com.koreait.mzpick_backend.service.fashion;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface FashionLikeService {
 
    ResponseEntity<ResponseDto> getLike(Integer fashionNumber);
    ResponseEntity<ResponseDto> postLike(Integer fashionNumber, String userId);
}
