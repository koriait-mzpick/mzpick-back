package com.koreait.mzpick_backend.dto.request.food;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostTraveFoodlVoteRequestDto {
    private String travelFoodVoteTitle;
    private String travelFoodVotePhoto1;
    private String travelFoodVotePhoto2;
    private String travelFoodVoteChoice1;
    private String travelFoodVoteChoice2;
}
