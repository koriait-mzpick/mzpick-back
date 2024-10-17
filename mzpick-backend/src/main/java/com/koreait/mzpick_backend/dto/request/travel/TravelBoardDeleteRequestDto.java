package com.koreait.mzpick_backend.dto.request.travel;
// 여행지 리스트 보기 요청 dto

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TravelBoardDeleteRequestDto {
    private String travel_photo;
    private String hash_tag;
    private String travel_like;
    private String travel_view;
    private String travel_date;
}
