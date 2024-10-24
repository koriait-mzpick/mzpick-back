package com.koreait.mzpick_backend.dto.response.mypage.vote;

import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetMyPageVoteTravelListResponseDto extends ResponseDto {
    
    private GetMyPageVoteTravelListResponseDto() {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }

    
}
