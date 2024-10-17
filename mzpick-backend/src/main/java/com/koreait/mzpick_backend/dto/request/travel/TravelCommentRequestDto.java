package com.koreait.mzpick_backend.dto.request.travel;
// 여행지 리스트 보기 요청 dto

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TravelCommentRequestDto {
    private String comment_text;
}
