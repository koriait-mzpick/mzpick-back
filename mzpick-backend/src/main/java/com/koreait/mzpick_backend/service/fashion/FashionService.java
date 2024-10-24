package com.koreait.mzpick_backend.service.fashion;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.fashion.PatchFashionRequestDto;
import com.koreait.mzpick_backend.dto.request.fashion.PostFashionRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.fashion.GetFashionDetailResponseDto;
import com.koreait.mzpick_backend.dto.response.fashion.GetFashionListResponseDto;

public interface FashionService {
    ResponseEntity<? super GetFashionListResponseDto> getFashionList(Integer page);

    ResponseEntity<? super GetFashionDetailResponseDto> getFashion(Integer fashionNumber);

    ResponseEntity<ResponseDto> postFashion(PostFashionRequestDto dto, String userId);

    ResponseEntity<ResponseDto> patchFashion(PatchFashionRequestDto dto, Integer fashionNumber, String userId);

    ResponseEntity<ResponseDto> deleteFashion(Integer fashionNumber, String userId);

    ResponseEntity<ResponseDto> upFashionViewCount(Integer travelNumber);
}
