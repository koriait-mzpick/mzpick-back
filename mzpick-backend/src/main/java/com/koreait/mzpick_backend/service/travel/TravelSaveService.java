package com.koreait.mzpick_backend.service.travel;

import org.springframework.http.ResponseEntity;

import com.koreait.mzpick_backend.dto.response.ResponseDto;

public interface TravelSaveService {
<<<<<<< HEAD
    
        ResponseEntity<ResponseDto> postSave(Integer travelNumber, String userId);

=======
    ResponseEntity<ResponseDto> putSave(Integer travelNumber, String userId);
>>>>>>> 242a098102e96732941b60a9bb4018fddb37203b
}
