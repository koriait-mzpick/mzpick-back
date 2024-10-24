package com.koreait.mzpick_backend.dto.response.mypage;

import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetMyPageBoardTravelListResponseDto extends ResponseDto {
    
    private GetMyPageBoardTravelListResponseDto() {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }

    
}
