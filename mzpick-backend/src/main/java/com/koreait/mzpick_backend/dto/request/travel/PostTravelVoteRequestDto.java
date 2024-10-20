package com.koreait.mzpick_backend.dto.request.travel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostTravelVoteRequestDto {
    private String travelVoteTitle;
    private String travelVotePhoto1;
    private String travelVotePhoto2;
    private String travelVoteChoice1;
    private String travelVoteChoice2;
}
