package com.koreait.mzpick_backend.service.implement.fashion;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.fashion.PatchFashionRequestDto;
import com.koreait.mzpick_backend.dto.request.fashion.PostFashionRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.fashion.FashionService;

public class FashionServiceImplement implements FashionService{

    @Override
    public ResponseEntity<ResponseDto> getFashion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFashion'");
    }

    @Override
    public ResponseEntity<ResponseDto> getFashionNum(Integer fashionNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFashionNum'");
    }

    @Override
    public ResponseEntity<ResponseDto> postFashion(PostFashionRequestDto dto, String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postFashion'");
    }

    @Override
    public ResponseEntity<ResponseDto> patchFashion(PatchFashionRequestDto dto, Integer fashionNumber, String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patchFashion'");
    }

    @Override
    public ResponseEntity<ResponseDto> deleteFashion(Integer fashionCafeNumber, String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteFashion'");
    }
    
}
