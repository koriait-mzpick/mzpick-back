package com.koreait.mzpick_backend.service.fashion;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.fashion.PatchFashionRequestDto;
import com.koreait.mzpick_backend.dto.request.fashion.PostFashionRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface FashionService {
    ResponseEntity<ResponseDto> getFashion();
    ResponseEntity<ResponseDto> getFashionNum(Integer fashionNumber);
    ResponseEntity<ResponseDto> postFashion(PostFashionRequestDto dto, String userId);

    ResponseEntity<ResponseDto> patchFashion(PatchFashionRequestDto dto, Integer fashionNumber, String userId);

    ResponseEntity<ResponseDto> deleteFashion(Integer fashionCafeNumber, String userId);
}
