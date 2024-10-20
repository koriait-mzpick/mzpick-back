package com.koreait.mzpick_backend.dto.request.fashion;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PosFashionlVoteRequestDto {
    private String FashionVoteTitle;
    private String FashionVotePhoto1;
    private String FashionVotePhoto2;
    private String FashionVoteChoice1;
    private String FashionVoteChoice2;
}