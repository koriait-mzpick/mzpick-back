package com.koreait.mzpick_backend.dto.request.cafe;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostTravelCafeVoteRequestDto {
    private String travelCafeVoteTitle;
    private String travelCafeVotePhoto1;
    private String travelCafeVotePhoto2;
    private String travelCafeVoteChoice1;
    private String travelCafeVoteChoice2;
}
