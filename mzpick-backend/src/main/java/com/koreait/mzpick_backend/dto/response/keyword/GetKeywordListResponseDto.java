package com.koreait.mzpick_backend.dto.response.keyword;

import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;
import com.koreait.mzpick_backend.entity.keyword.KeywordEntity;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import lombok.Getter;

@Getter
public class GetKeywordListResponseDto extends ResponseDto {
    
    private List<String> keywords;

    private GetKeywordListResponseDto(List<KeywordEntity> keywordEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        List<String> keywords = new ArrayList<>();
        for (KeywordEntity keywordEntity: keywordEntities) keywords.add(keywordEntity.getKeywordContent());
        this.keywords = keywords;
    }

    public static ResponseEntity<GetKeywordListResponseDto> success(List<KeywordEntity> keywordEntities) {

        GetKeywordListResponseDto responseBody = new GetKeywordListResponseDto(keywordEntities);
       return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
