package com.koreait.mzpick_backend.service.fashion;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface FashionLikeService {

    ResponseEntity<ResponseDto> putLike(Integer fashionNumber, String userId);
}
