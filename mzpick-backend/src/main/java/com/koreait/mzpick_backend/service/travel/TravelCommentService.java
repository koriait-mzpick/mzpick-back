package com.koreait.mzpick_backend.service.travel;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.request.travel.PostTravelCommentRequestDto;
import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface  TravelCommentService {
<<<<<<< HEAD
    ResponseEntity<ResponseDto> getComment(Integer travelNumber);
    ResponseEntity<ResponseDto> postComment(PostTravelCommentRequestDto dto, String userId);
    ResponseEntity<ResponseDto> deletecomment(Integer travelCommentNumber);
=======
        ResponseEntity<ResponseDto> postTravelComment(PostTravelCommentRequestDto dto,Integer travelNumber, String userId);
        ResponseEntity<ResponseDto> deleteTravelComment(Integer travelCommentNumber, String userId);
>>>>>>> 242a098102e96732941b60a9bb4018fddb37203b
}

