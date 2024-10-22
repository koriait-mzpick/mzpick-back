package com.koreait.mzpick_backend.controller.travel;

import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
=======
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
>>>>>>> 242a098102e96732941b60a9bb4018fddb37203b
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.travel.TravelSaveService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/travel/save")
@RequiredArgsConstructor
public class TravelSaveController {
<<<<<<< HEAD
    
    private final TravelSaveService travelSaveService;

   @PostMapping("/{travelNumber}")
   public ResponseEntity<ResponseDto> postSave(
    @PathVariable("travelNumber")Integer travelNumber
   ) {
        ResponseEntity<ResponseDto> response = travelSaveService.postSave(travelNumber, null);
        return response;
   }
=======

    private final TravelSaveService travelSaveService;

    // @GetMapping("/{travelNumber}")
    // public ResponseEntity<ResponseDto> postSave(
    // @RequestBody @Valid Integer travelNumber
    // ) {

    // ResponseEntity<ResponseDto> response = travelSaveService.postSave();
    // return response;
    // }

    @PutMapping("/{travelNumber}")
    public ResponseEntity<ResponseDto> putSave(
            @PathVariable("travelNumber") Integer travelNumber,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<ResponseDto> response = travelSaveService.putSave(travelNumber, userId);
        return response;
    }
>>>>>>> 242a098102e96732941b60a9bb4018fddb37203b
}
