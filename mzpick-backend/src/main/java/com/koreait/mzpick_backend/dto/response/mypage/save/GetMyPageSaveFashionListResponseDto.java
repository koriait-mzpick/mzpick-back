package com.koreait.mzpick_backend.dto.response.mypage.save;

import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetMyPageSaveFashionListResponseDto extends ResponseDto {
    
    private GetMyPageSaveFashionListResponseDto() {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }

    
}
