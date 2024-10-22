package com.koreait.mzpick_backend.controller.keyword;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.mzpick_backend.service.keyword.KeywordService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/popular/Food")
@RequiredArgsConstructor
public class KeywordController {
    
    private final KeywordService keywordService;

    // @GetMapping(value={"", "/"})
    // public ResponseEntity<ResponseDto> getKeyword() {
    //     ResponseEntity<ResponseDto> response = keywordService.getKeyword();
    //     return response;
    // }

    // @PostMapping("/write")
    // public ResponseEntity<ResponseDto> postKeyword(
    //     @RequestBody @Valid String dto,
    //     @AuthenticationPrincipal String userId
    // ) {
    //     ResponseEntity<ResponseDto> response = keywordService.postKeyword(dto, userId);
    //     return response;
    // }
}
