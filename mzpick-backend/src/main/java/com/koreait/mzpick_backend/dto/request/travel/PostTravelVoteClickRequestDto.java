package com.koreait.mzpick_backend.dto.request.travel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostTravelVoteClickRequestDto {
    private String travelVoteResultChoice;
}
