package com.koreait.mzpick_backend.service.fashion;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface FashionCommentService {
    
    ResponseEntity<ResponseDto> getComment(Integer fashionNumber);
    ResponseEntity<ResponseDto> postComment(Integer fashionNumber, String userId);
    ResponseEntity<ResponseDto> deleteComment(Integer fashionCommentNumber);
}
