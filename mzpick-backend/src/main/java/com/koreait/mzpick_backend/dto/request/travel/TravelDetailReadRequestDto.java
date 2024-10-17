package com.koreait.mzpick_backend.dto.request.travel;
// 여행지 리스트 보기 요청 dto

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TravelDetailReadRequestDto {
    private String travelTitle;
    private String travelPhoto;
    private String hashTag;
    private String travelLike;
    private String travelView;
    private String travelDate;
}
