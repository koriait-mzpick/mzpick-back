package com.koreait.mzpick_backend.controller.travel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.service.travel.TravelSaveService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/travel/save")
@RequiredArgsConstructor
public class TravelSaveController {
    
    private final TravelSaveService travelSaveService;

   @PostMapping("/{travelNumber}")
   public ResponseEntity<ResponseDto> postSave(
    @PathVariable("travelNumber")Integer travelNumber
   ) {
        ResponseEntity<ResponseDto> response = travelSaveService.postSave(travelNumber, null);
        return response;
   }
}
