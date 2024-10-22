package com.koreait.mzpick_backend.service.travel;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface TravelLikeService {
<<<<<<< HEAD
    ResponseEntity<ResponseDto> getLike(Integer travelNumber);
    ResponseEntity<ResponseDto> postLike(String userId);
=======
    ResponseEntity<ResponseDto> putLike(Integer travelNumber, String userId);
>>>>>>> 242a098102e96732941b60a9bb4018fddb37203b
}
