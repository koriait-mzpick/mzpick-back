package com.koreait.mzpick_backend.dto.request.stay;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostTraveStaylVoteRequestDto {
    private String travelStayVoteTitle;
    private String travelStayVotePhoto1;
    private String travelStayVotePhoto2;
    private String travelStayVoteChoice1;
    private String travelStayVoteChoice2;
}
