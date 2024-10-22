package com.koreait.mzpick_backend.controller.stay;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.service.stay.TravelStayService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/stay")
@RequiredArgsConstructor
public class TravelStayController {
    private final TravelStayService travelStayService;

    // @GetMapping(value = { "", "/" })
    // public ResponseEntity<ResponseDto> getTravelStay() {
    //     ResponseEntity<ResponseDto> resposne = travelStayService.getTravelStay();
    //     return resposne;
    // }

    // @GetMapping("/{travelStayNumber}")
    // public ResponseEntity<ResponseDto> getTravelStayNum(
    //         @PathVariable("travelStayNumber") Integer travelStayNumber) {
    //     ResponseEntity<ResponseDto> resposne = travelStayService.getTravelStayNum(travelStayNumber);
    //     return resposne;
    // }

    // @PostMapping(value = { "", "/" })
    // public ResponseEntity<ResponseDto> postTravelStay(
    //         @RequestBody @Valid PostTravelStayRequestDto requestBody,
    //         @AuthenticationPrincipal String userId) {
    //     ResponseEntity<ResponseDto> resposne = travelStayService.postTravelStay(requestBody, userId);
    //     return resposne;
    // }

    // @DeleteMapping("/{travelStayNumber}")
    // public ResponseEntity<ResponseDto> deleteTravelCafe(
    //         @PathVariable("travelStayNumber") Integer travelStayNumber,
    //         @AuthenticationPrincipal String userId) {
    //     ResponseEntity<ResponseDto> response = travelStayService.deleteTravelStay(travelStayNumber, userId);
    //     return response;
    // }

    // @PatchMapping("/{travelStayNumber}")
    // public ResponseEntity<ResponseDto> patchTravelCafe(
    //         @RequestBody @Valid PatchTravelStayRequestDto requestBody,
    //         @PathVariable("travelStayNumber") Integer travelStayNumber,
    //         @AuthenticationPrincipal String userId) {
    //     ResponseEntity<ResponseDto> response = travelStayService.patchTravelStay(requestBody, travelStayNumber, userId);
    //     return response;
    // }
}
