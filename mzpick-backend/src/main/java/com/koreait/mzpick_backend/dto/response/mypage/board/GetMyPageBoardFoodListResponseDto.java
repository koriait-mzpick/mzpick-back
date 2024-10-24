package com.koreait.mzpick_backend.dto.response.mypage.board;

import com.koreait.mzpick_backend.dto.response.ResponseCode;
import com.koreait.mzpick_backend.dto.response.ResponseDto;
import com.koreait.mzpick_backend.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetMyPageBoardFoodListResponseDto extends ResponseDto {
    
    private GetMyPageBoardFoodListResponseDto() {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }

    
}
